#!/bin/bash
IMAGE=maven-rates-plugin-api
# clean
docker rmi $IMAGE
docker rmi hldtux/$IMAGE
# build and push
docker build --platform linux/amd64,linux/arm64 . -t $IMAGE --no-cache && \
docker tag $IMAGE hldtux/$IMAGE && \
docker push hldtux/$IMAGE && echo "Pushed"