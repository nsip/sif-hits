#!/bin/bash
SIF_HOME=/srv/sif
TMP_HOME=/srv/src/sif-hits
SITE=${APP_URL:=localhost:8080}
RELEASE_NAME=${project.artifactId}-${project.version}
FINAL_NAME=${finalName}
TOMCAT_HOME=/usr/local/tomcat

echo Updating provider config for ${SITE}
cat ${TMP_HOME}/dist/config/HitsProvider.properties > ${SIF_HOME}/HitsProvider.properties
echo "" >> ${SIF_HOME}/HitsProvider.properties
echo "env.connector.url=http://${SITE}/SIF3InfraREST/hits" >> ${SIF_HOME}/HitsProvider.properties
echo "env.connector.url.secure=https://${SITE}/SIF3InfraREST/hits" >> ${SIF_HOME}/HitsProvider.properties
echo "" >> ${SIF_HOME}/HitsProvider.properties
cat ${TMP_HOME}/dist/config/provider.classes >> ${SIF_HOME}/HitsProvider.properties

echo Updating database credentials
cat ${TMP_HOME}/dist/config/sif3infra.hibernate.properties > ${SIF_HOME}/sif3infra.hibernate.properties
echo "hibernate.connection.url=jdbc:mysql://${DB_URL:=localhost}:${DB_PORT:=3306}/hits_sif3_infra" >> ${SIF_HOME}/sif3infra.hibernate.properties
echo "hibernate.connection.username=${DB_USER:=sif3}" >> ${SIF_HOME}/sif3infra.hibernate.properties
echo "hibernate.connection.password=${DB_PASS:=sif3}" >> ${SIF_HOME}/sif3infra.hibernate.properties

cat ${TMP_HOME}/dist/config/sifhits.database.properties > ${SIF_HOME}/sifhits.database.properties
echo "hits.connection.url=jdbc:mysql://${DB_URL}:${DB_PORT}/hits_sif3_infra" >> ${SIF_HOME}/sifhits.database.properties
echo "hits.connection.format=jdbc:mysql://${DB_URL}:${DB_PORT}/{0}" >> ${SIF_HOME}/sifhits.database.properties
echo "hits.connection.username=${DB_USER}" >> ${SIF_HOME}/sifhits.database.properties
echo "hits.connection.password=${DB_PASS}" >> ${SIF_HOME}/sifhits.database.properties

echo "flyway.url=jdbc:mysql://${DB_URL}:${DB_PORT}/hits_sif3_infra" > ${SIF_HOME}/flyway.properties
echo "flyway.user=${DB_USER}" >> ${SIF_HOME}/flyway.properties
echo "flyway.password=${DB_PASS}" >> ${SIF_HOME}/flyway.properties

pushd ${TMP_HOME}
mvn -Dflyway.configFiles=${SIF_HOME}/flyway.properties flyway:migrate
popd

catalina.sh run