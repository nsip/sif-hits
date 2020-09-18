#!/bin/bash

# env vars
SIF_HOME=/var/sif/hitsprovider
SITE=`cat ${SIF_HOME}/instance`
RELEASE_NAME=sifhits-2.11.0
FINAL_NAME=SIF3InfraREST
TOMCAT_HOME=/var/lib/tomcat7
TIMESTAMP=`date +%Y%m%dT%H%M%S`
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

echo Updating provider config for ${SITE}
cp ${DIR}/../config/environments/provider/template/direct/HITS.xml ${SIF_HOME}/environments/provider/template/direct/HITS.xml
cat ${DIR}/../config/sites/${SITE}/providers/HitsProvider.properties > ${SIF_HOME}/providers/HitsProvider.properties
echo "" >> ${SIF_HOME}/providers/HitsProvider.properties
cat ${DIR}/../config/provider.classes >> ${SIF_HOME}/providers/HitsProvider.properties
cp ${DIR}/../config/sites/${SITE}/*.* ${SIF_HOME}/

echo Deploying latest version to tomcat
sudo service tomcat7 stop
sudo cp ${TOMCAT_HOME}/webapps/${FINAL_NAME}.war ${TOMCAT_HOME}/webapps/${FINAL_NAME}.${TIMESTAMP}
sudo cp $DIR/${RELEASE_NAME}.war ${TOMCAT_HOME}/webapps/${FINAL_NAME}.war
sudo service tomcat7 start


