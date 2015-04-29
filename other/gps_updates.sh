#!/bin/bash

# Generate some location updates to REST / GPS server using curl
curl -i -X POST -H "Content-Type:application/json" -d '{  "lat" : "60.2056530",  "lon" : "21.88371", "speed" : "6.1", "timestamp" : "2015-04-28'T'16:50:25Z" }' http://localhost:8080/gps
curl -i -X POST -H "Content-Type:application/json" -d '{  "lat" : "60.2056640",  "lon" : "21.88372", "speed" : "6.0", "timestamp" : "2015-04-28'T'16:50:30Z" }' http://localhost:8080/gps
curl -i -X POST -H "Content-Type:application/json" -d '{  "lat" : "60.2056645",  "lon" : "21.88423", "speed" : "6.1", "timestamp" : "2015-04-28'T'16:50:35Z" }' http://localhost:8080/gps
curl -i -X POST -H "Content-Type:application/json" -d '{  "lat" : "60.2056720",  "lon" : "21.88484", "speed" : "6.2", "timestamp" : "2015-04-28'T'16:50:40Z" }' http://localhost:8080/gps
curl -i -X POST -H "Content-Type:application/json" -d '{  "lat" : "60.2056750",  "lon" : "21.88554", "speed" : "6.3", "timestamp" : "2015-04-28'T'16:50:45Z" }' http://localhost:8080/gps
curl -i -X POST -H "Content-Type:application/json" -d '{  "lat" : "60.2056820",  "lon" : "21.88645", "speed" : "6.5", "timestamp" : "2015-04-28'T'16:50:50Z" }' http://localhost:8080/gps
