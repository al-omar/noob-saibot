import datetime
import time
import os
import sys
import subprocess

format = "%Y-%d-%b-%H:%M:%S"
with open("delta.txt") as f:
      for lines in f:
          today = datetime.datetime.today()
          s = today.strftime(format)
          filename = s+".sql"
          cmd = lines
          print(cmd)
          with open(filename,"wb") as out:
              subprocess.Popen(cmd,stdout=out, shell=True)
          time.sleep(1)
