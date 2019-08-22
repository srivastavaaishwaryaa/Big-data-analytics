#!/usr/bin/env python
import sys

for line in sys.stdin:
	id=line.split(",")[0]
	print(id+"\t1")