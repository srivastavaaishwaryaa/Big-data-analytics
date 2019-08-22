#!/usr/bin/env python
import sys


for line in sys.stdin:
	if "OBJECTID" not in line: #skip the header row
		listvals=line.split(",")
		objectid=listvals[0]
		name=listvals[1]
		geom=listvals[2].replace("(","").replace(")","")
		latitude=geom.split(" ")[1]
		longitude=geom.split(" ")[2]
		subwayline=listvals[3]
		print(objectid+","+name+","+latitude+","+longitude+","+subwayline)