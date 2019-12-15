import hdfs
import json
from hdfs.ext.avro import AvroReader

SCH_DIR = "../assignment-2/src/main/java/ca/concordia/coen424/id27649460/avro"
WEBHDFS_URL = "http://localhost:9870"
OUTPUT_DIR = "/Output"
OUTPUT_FILE = "part-r-00000.avro"


def read_output():
    hdfs_cli = hdfs.InsecureClient("http://localhost:9870")

    with AvroReader(hdfs_cli, f"{OUTPUT_DIR}/{OUTPUT_FILE}") as avro_rdr:
        for record in avro_rdr:
            print(f"Number of values:\t{len(record['sortedValues'])}")
            print(f"Minimum:\t\t{record['min']}")
            print(f"Maximum:\t\t{record['max']}")
            print(f"Median:\t\t\t{record['median']}")
            print(f"90th percentile:\t{record['ninety']}")
            print(f"Standard Deviation:\t{record['stdDev']}")
            print(f"Sorted scaled values: {record['scaledValues'][:20]} [...]")
            print(f"Rest of the values are written in Output/result.json")
            with open("Output/result.json", "w+") as file:
                json.dump(record, file)


if __name__ == "__main__":
    read_output()
