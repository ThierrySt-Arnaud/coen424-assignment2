import argparse
import json
import logging
import os
import shlex
import subprocess
import hdfs

from aiohttp import web
from hdfs.ext.avro import AvroReader

DEFAULT_PORT = 50000
SCH_DIR = "../assignment-2/src/main/java/ca/concordia/coen424/id27649460/avro"
WEBHDFS_URL = "http://localhost:9870"
OUTPUT_DIR = "/Output"
OUTPUT_FILE = "part-r-00000.avro"


def server_setup():
    logging.basicConfig(format='%(asctime)s - %(message)s',
                        datefmt='%d-%b-%y %H:%M:%S', level=logging.INFO)
    a = web.Application()
    routes = web.RouteTableDef()

    @routes.get('/')
    async def get_search_results(request):
        try:
            params = await request.json()
            params = {"file": params['file'], "metric": params['metric']}
        except (json.decoder.JSONDecodeError, KeyError):
            logging.error("Invalid JSON body received")
            raise web.HTTPBadRequest()
        result = execute_mr(params)

        return web.json_response(result)

    a.add_routes(routes)
    return a


def parser_setup():
    p = argparse.ArgumentParser(description="MapReduceServer")

    p.add_argument("--local", action="store_true",
                   help="Bind server to local interface only")

    class PortAction(argparse.Action):
        def __call__(self, prsr, namespace, port, option_string=None):
            if port < 0 or port > 65535:
                prsr.error(f"{option_string} must be between 0 and 65535")

            setattr(namespace, self.dest, port)

    p.add_argument("-p", "--port", action=PortAction, type=int, default=DEFAULT_PORT,
                   help=f"specify port, defaults to {DEFAULT_PORT}")
    return p


def execute_mr(params):
    targetargs = shlex.split(f'mvn exec:java -q -Dexec.mainClass=ca.concordia.coen424.id27649460.MapReduceSort'
                             f' -Dexec.args="{params["file"]} {params["metric"]}"')
    subprocess.run(targetargs,
                   cwd=f"{os.path.dirname(os.path.realpath(__file__))}/assignment-2")

    hdfs_cli = hdfs.InsecureClient("http://localhost:9870")
    with AvroReader(hdfs_cli, f"{OUTPUT_DIR}/{OUTPUT_FILE}") as avro_rdr:
        for record in avro_rdr:
            result = record
    hdfs_cli.delete("/Output", recursive=True)
    return result


if __name__ == '__main__':
    parser = parser_setup()
    args = parser.parse_args()
    app = server_setup()
    web.run_app(app, host="127.0.0.1" if args.local else None, port=args.port)
