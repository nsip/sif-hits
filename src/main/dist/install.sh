#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
cd $DIR/..
git pull
mvn install:install-file -Dfile=dist/sif3-common-${sif3.framework.version}.jar
mvn install:install-file -Dfile=dist/sif3-infra-common-${sif3.framework.version}.jar
mvn install:install-file -Dfile=dist/sif3-infra-model-${sif3.framework.version}.jar
mvn install:install-file -Dfile=dist/sif3-infra-rest-${sif3.framework.version}.jar
mvn install:install-file -Dfile=dist/sifau-datamodel-${sif3.datamodel.version}.jar


