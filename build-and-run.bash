#!/bin/bash

set -x

CONTAINER_NAME=roster

docker build --tag=${CONTAINER_NAME} .
source ./down.bash
docker run -d --name=${CONTAINER_NAME} --hostname=${CONTAINER_NAME} -p 8080:8080 ${CONTAINER_NAME}
