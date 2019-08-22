#!/usr/bin/env python
import sys

current_key=None
count=0

for line in sys.stdin:
	key, value=line.split(',',1)

	if current_key is None:
		current_key=key
	
	if key==current_key:
		count+=1
	else:
		if count>0:
			print(current_key+','+str(count))
		else:
			print(current_key+',1')
		count=0
		current_key=key

if count>0:
	print(current_key+','+str(count))
else:
	print(current_key+',1')