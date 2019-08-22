#!/usr/bin/env python
import sys

for line in sys.stdin:
	geo=line.split(",")[2]
	print(str(len(geo))+",1")