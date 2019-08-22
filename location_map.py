#!/usr/bin/env python
import sys

for line in sys.stdin:
	subway_loc=line.split(",")[2]
	print(subway_loc+",1")