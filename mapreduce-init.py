import subprocess
import shutil
import glob
from wl_mr_utils import populate_hdfs


def main():
    subprocess.run(["stop-dfs.sh"])
    subprocess.run(["stop-yarn.sh"])
    tmpdirs = glob.glob("/tmp/hadoop*")
    for d in tmpdirs:
        shutil.rmtree(d)
    subprocess.run(["hdfs", "namenode", "-format"])
    subprocess.run(["start-dfs.sh"])
    subprocess.run(["start-yarn.sh"])
    populate_hdfs.populate_hdfs("wl_mr_utils")


if __name__ == "__main__":
    main()
