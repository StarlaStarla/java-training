#!/bin/sh
# Usage: wait-for-it.sh host:port [-- command args]
#   -h HOST | --host=HOST       Host or IP under test
#   -p PORT | --port=PORT       TCP port under test
#   Alternatively, you can specify the host and port as host:port
echo "Waiting for MySQL..."

HOST=$1
PORT=$2

util nc -z $HOST $PORT; do
    echo "Waiting for MYSQL..."
    sleep 2
done

echo "MySQL is ready."