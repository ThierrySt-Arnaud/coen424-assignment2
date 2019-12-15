import os
import shlex
import subprocess
import argparse
import hdfs
from wl_mr_utils import read_output


def main():
    parser = argparse.ArgumentParser(description="Execute MapReduce job")
    parser.add_argument("file", help="Which file to use", choices=["testing", "training"])
    parser.add_argument("metric", help="Which metric to use", choices=["cpu", "netin", "netout", "mem"])
    args = parser.parse_args()
    targetargs = shlex.split(f'mvn exec:java -q -Dexec.mainClass=ca.concordia.coen424.id27649460.MapReduceSort'
                             f' -Dexec.args="{args.file} {args.metric}"')
    subprocess.run(targetargs,
                   cwd=f"{os.path.dirname(os.path.realpath(__file__))}/assignment-2")
    read_output.read_output()
    hdfs_cli = hdfs.InsecureClient("http://localhost:9870")
    hdfs_cli.delete("/Output", recursive=True)


if __name__ == "__main__":
    main()
