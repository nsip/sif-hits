#!/usr/bin/env bash
docker push nsip/sif-hits:latest
docker push nsip/sif-hits-test:latest
VERSION=`cat dist/project.version`
docker push nsip/sif-hits:${VERSION}
docker push nsip/sif-hits-test:${VERSION}
