import csv
import json
import hdfs
from hdfs.ext.avro import AvroWriter

WEBHDFS_URL = "http://localhost:9870"
USERNAME = "thierry"
SOURCE_URL = "https://raw.githubusercontent.com/"
SOURCE_REPO = "haniehalipour/Online-Machine-Learning-for-Cloud-Resource-Provisioning-of-Microservice-Backend-Systems/"
DATA_DIR = "master/Workload%20Data/"
OUTPUT_DIR = "/NDBench/"
FILE_PREFIX = "NDBench-"
FILES = ["testing", "training"]
SCH_DIR = "../assignment-2/src/main/java/ca/concordia/coen424/id27649460/avro"
SCH_FILE = "ndbench.avsc"
COLUMNS = ("cpu", "netin", "netout", "mem", "tgt")


def populate_hdfs(path_prefix):
    hdfs_cli = hdfs.InsecureClient("http://localhost:9870")
    hdfs_cli.makedirs(OUTPUT_DIR)

    with open(f"{path_prefix}/{SCH_DIR}/{SCH_FILE}", "r") as schema_file:
        sch = json.load(schema_file)

    for (f, filename) in [(f, f"{path_prefix}/../{FILE_PREFIX}{f}.csv") for f in FILES]:
        with open(filename, "r") as csv_file:
            csv_rdr = csv.DictReader(csv_file)
            hdfs_cli.makedirs(f"{OUTPUT_DIR}/{f}")
            with AvroWriter(hdfs_cli, f"{OUTPUT_DIR}/{f}/{f}.avro", schema=sch, overwrite=True) as avro_wtr:
                for record in [{sch["fields"][0]["name"]: int(r['CPUUtilization_Average']),
                                sch["fields"][1]["name"]: int(r['NetworkIn_Average']),
                                sch["fields"][2]["name"]: int(r['NetworkOut_Average']),
                                sch["fields"][3]["name"]: float(r['MemoryUtilization_Average']),
                                sch["fields"][4]["name"]: float(r['Final_Target'])} for r in csv_rdr]:
                    avro_wtr.write(record)


if __name__ == "__main__":
    populate_hdfs(".")
