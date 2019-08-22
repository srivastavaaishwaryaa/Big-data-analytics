#!/usr/bin/env python
import sys

for line in sys.stdin:
	subway_line=line.split(",")[3]
	print(subway_line+",1")