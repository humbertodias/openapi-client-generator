#!/bin/bash
IMAGE=maven-rates-plugin-api
# clean
docker rmi $IMAGE
docker rmi hldtux/$IMAGE
# build and push
docker build . -t $IMAGE && \
docker tag $IMAGE hldtux/$IMAGE && \
docker push hldtux/$IMAGE && echo "Pushed"