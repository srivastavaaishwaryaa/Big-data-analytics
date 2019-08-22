#!/usr/bin/env python
import sys

for line in sys.stdin:
	subway_name=line.split(",")[1]
	print(str(len(subway_name))+",1")