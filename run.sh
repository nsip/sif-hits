#!/usr/bin/env bash
docker run --env-file env.sh -p 8080:8080 -p 8009:8009 sif-hits
