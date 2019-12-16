import requests
import argparse
import json
from ipaddress import ip_address

DEFAULT_PORT = 50000
DEFAULT_IP = "35.227.70.193"


def main(parser):
    args = parser.parse_args()
    sourcefile = args.file
    metric = args.metric
    host = str(args.hostip) if not args.local else "localhost"
    port = args.port
    payload = json.dumps({"file": sourcefile, "metric": metric})
    response = requests.get(f"http://{host}:{port}", data=payload)
    record = response.json()
    print(f"Number of values:\t{len(record['scaledValues'])}")
    print(f"Minimum:\t\t{record['min']}")
    print(f"Maximum:\t\t{record['max']}")
    print(f"Median:\t\t\t{record['median']}")
    print(f"90th percentile:\t{record['ninety']}")
    print(f"Standard Deviation:\t{record['stdDev']}")
    print(f"Sorted scaled values: {record['scaledValues'][:20]} [...]")
    print(f"Rest of the values are written in Output/result.json")
    with open("Output/result.json", "w+") as file:
        json.dump(record, file)


def parser_setup():
    par = argparse.ArgumentParser(description="MapReduce Client")

    par.add_argument("file", help="Which file to use", choices=["testing", "training"])
    par.add_argument("metric", help="Which metric to use", choices=["cpu", "netin", "netout", "mem"])
    locrem = par.add_mutually_exclusive_group()
    locrem.add_argument("-ip", "--hostip", type=ip_address, default=DEFAULT_IP,
                        help="specify IP address, "
                             "defaults to cloud instance")
    locrem.add_argument("--local", action="store_true",
                        help="connect to a locally running server, "
                             "equivalent to --hostip 127.0.0.1")

    class PortAction(argparse.Action):
        def __call__(self, prsr, namespace, port, option_string=None):
            if port < 0 or port > 65535:
                prsr.error(f"{option_string} must be between 0 and 65535")

            setattr(namespace, self.dest, port)

    par.add_argument("-p", "--port", action=PortAction, type=int, default=DEFAULT_PORT,
                     help=f"specify port, defaults to {DEFAULT_PORT}")
    return par


if __name__ == "__main__":
    p = parser_setup()
    main(p)
