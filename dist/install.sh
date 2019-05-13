#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
cd $DIR/..
git pull
mvn install:install-file -Dfile=dist/sif3-common-0.14.0.jar
mvn install:install-file -Dfile=dist/sif3-infra-common-0.14.0.jar
mvn install:install-file -Dfile=dist/sif3-infra-model-0.14.0.jar
mvn install:install-file -Dfile=dist/sif3-infra-rest-0.14.0.jar
mvn install:install-file -Dfile=dist/sifau-datamodel-au-3.4.4.jar


