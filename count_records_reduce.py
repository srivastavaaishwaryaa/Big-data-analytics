#!/usr/bin/env python
import sys

recordname="record number"
recordct=-1 #start with -1 due to header

for line in sys.stdin:
	key, value=line.split('\t',1)
	value=int(value)
	recordct+=value
	
print(recordname+"\t"+str(recordct))
	
	