#!/bin/bash

set - x

CONTAINER_NAME=roster

docker stop ${CONTAINER_NAME} ; docker rm ${CONTAINER_NAME}
