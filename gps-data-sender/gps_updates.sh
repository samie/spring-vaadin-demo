#!/bin/bash

# Generate some location updates to REST / GPS server using curl

filename='data.txt'
idx=0
max=-1
if [ -n "$1" ]; then
    max=$1
fi
while read D ; do
    curl -i -X POST -H "Content-Type:application/json" -d  "$D" http://localhost:8080/gps
    sleep 1;
    (( idx++ ))
    if [ "$max" -gt 0 ] && [ "$idx" -ge "$max" ]; then 
       echo "Total $idx GPS updates sent."
       exit 0
    fi
done <$filename
