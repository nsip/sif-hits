#!/usr/bin/env bash
mvn clean
mvn compile package
mvn exec:java -Dexec.mainClass=sif3.hits.rest.consumer.util.XMLGenerator -Dexec.classpathScope=test
mvn package install
cp -R src/main/dist/keystores/* dist/keystores/
if [[ "${1}" == "deps" ]]; then
    docker build -t sif-hits-deps -f dist/Dockerfile.deps .
fi
docker build -t sif-hits -f dist/Dockerfile .
docker build -t sif-hits-test -f dist/Dockerfile.test .

VERSION=`cat dist/project.version`
docker tag sif-hits:latest sif-hits:$VERSION
docker tag sif-hits-test:latest sif-hits-test:$VERSION
docker tag sif-hits:latest nsip/sif-hits:latest
docker tag sif-hits:latest nsip/sif-hits:$VERSION
docker tag sif-hits-test:latest nsip/sif-hits-test:latest
docker tag sif-hits-test:latest nsip/sif-hits-test:$VERSION
