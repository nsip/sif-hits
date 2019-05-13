#!/bin/bash
SIF_HOME=/var/sif/hitsprovider
RELEASE_NAME=sifhits-2.8.0
FINAL_NAME=SIF3InfraREST
TOMCAT_HOME=/var/lib/tomcat8
TIMESTAMP=`date +%Y%m%dT%H%M%S`
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
cd $DIR/..
PROVIDERS=(`find src -name *Provider.java | awk -F '[/.]' '{ print $8 }'`)
TARGET_URL=`cat ${SIF_HOME}/providers/HitsProvider.properties | grep env.connector.url.secure | grep -v '#' | awk -F '=' '{print $2}'`
PROVIDER_CONFIG=""
PROVIDER_CLASSES="provider.classes="
for PROVIDER in "${PROVIDERS[@]}"; do
   if [ -z "$PROVIDER_CONFIG" ]; then
      PROVIDER_CONFIG="$PROVIDER_CLASSES"
   else
      PROVIDER_CONFIG="${PROVIDER_CONFIG},"
   fi
   if [ "$PROVIDER" != "HitsBaseProvider" ] && [ "$PROVIDER" != "AUDataModelProvider" ]; then
      PROVIDER_CONFIG="${PROVIDER_CONFIG}${PROVIDER}"
   fi
done
sed -i "s/^${PROVIDER_CLASSES}=.*/${PROVIDER_CONFIG}/" ${SIF_HOME}/providers/HitsProvider.properties
mvn -q install:install-file -Dfile=dist/sif3-common-0.14.0.jar
mvn -q install:install-file -Dfile=dist/sif3-infra-common-0.14.0.jar
mvn -q install:install-file -Dfile=dist/sif3-infra-model-0.14.0.jar
mvn -q install:install-file -Dfile=dist/sif3-infra-rest-0.14.0.jar
mvn -q install:install-file -Dfile=dist/sifau-datamodel-au-3.4.4.jar
mvn flyway:migrate -Dflyway.configFiles=/var/sif/hitsprovider/hibernate/flyway.properties
sudo service tomcat8 stop
sudo cp ${TOMCAT_HOME}/webapps/${FINAL_NAME}.war ${TOMCAT_HOME}/webapps/${FINAL_NAME}.${TIMESTAMP}
sudo cp $DIR/${RELEASE_NAME}.war ${TOMCAT_HOME}/webapps/${FINAL_NAME}.war
sudo service tomcat8 start
echo Wait 60 seconds before running tests...

