#!/usr/bin/env python
import sys

for line in sys.stdin:
	subway_name=line.split(",")[1]
	print(subway_name+",1")