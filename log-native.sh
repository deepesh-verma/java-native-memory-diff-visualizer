#!/bin/bash
PID=$1
INTERVAL=$2
COUNT=100

jcmd $PID VM.native_memory | grep " (reserved=" | sed 's/- *\(.*\) (reserved=.*/\1/' | sed 's/ /_/g ' | xargs echo Time | sed ' s/ /,/g' 

COUNTER=0
while [ $COUNTER -lt $COUNT ]; do
    jcmd $PID VM.native_memory | grep " (reserved=" | sed 's/.*(reserved=//1' | sed 's/,.*//1' | xargs echo $(date +'%H:%M:%S ' ) | sed ' s/ /,/g ' 
    sleep $INTERVAL
    let COUNTER=COUNTER+1
done
