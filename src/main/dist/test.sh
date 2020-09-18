#!/usr/bin/env bash
if [ -z "$1" ]; then
	echo "Create a new empty database in this environment. Either on the command line or through the dashboard."
	echo "Then run this container with the Application Key as the only argument."
	echo "eg."
	echo "   docker run sif-hits-test 90c59ecb9bb84db19d52500bcd02ae5c"
	exit 0
fi

SIF_HOME=/srv/src/sif-hits/src/test/resources
BAK_HOME=/srv/src/sif-hits/src/test/xxx
TMP_HOME=/srv/src/sif-hits
SITE=${APP_URL:=localhost:8080}
RELEASE_NAME=${project.artifactId}-${project.version}
FINAL_NAME=${finalName}

mv ${SIF_HOME} ${BAK_HOME}
mkdir -p ${SIF_HOME}

mv ${BAK_HOME}/xml ${SIF_HOME}/xml
cp ${BAK_HOME}/environment.properties ${SIF_HOME}/
cp ${BAK_HOME}/log4j.properties ${SIF_HOME}/
cp ${BAK_HOME}/c3p0.properties ${SIF_HOME}/
touch ${SIF_HOME}/hibernate.properties
sed -i 's/DEBUG/INFO/g' ${SIF_HOME}/log4j.properties


echo Updating provider config for ${SITE}
cat ${TMP_HOME}/dist/config/TestConsumer.properties > ${SIF_HOME}/TestConsumer.properties
echo "" >> ${SIF_HOME}/TestConsumer.properties
echo "env.application.key=${1}" >> ${SIF_HOME}/TestConsumer.properties
echo "env.userToken=${1}" >> ${SIF_HOME}/TestConsumer.properties
echo "env.pwd=${1}" >> ${SIF_HOME}/TestConsumer.properties
echo "" >> ${SIF_HOME}/TestConsumer.properties
echo "env.baseURI=http://${SITE}/SIF3InfraREST/hits/environments/environment" >> ${SIF_HOME}/TestConsumer.properties

echo Updating database credentials
cat ${TMP_HOME}/dist/config/sif3infra.hibernate.properties > ${SIF_HOME}/sif3infra.hibernate.properties
echo "hibernate.connection.url=jdbc:mysql://${DB_URL:=localhost}:${DB_PORT:=3306}/hits_sif3_infra" >> ${SIF_HOME}/sif3infra.hibernate.properties
echo "hibernate.connection.username=${DB_USER:=sif3}" >> ${SIF_HOME}/sif3infra.hibernate.properties
echo "hibernate.connection.password=${DB_PASS:=sif3}" >> ${SIF_HOME}/sif3infra.hibernate.properties

mvn -q -Dtest=ConsumerTests -DskipTests=false test
mvn surefire-report:report-only
mvn site -DgenerateReports=false
cp -R ${TMP_HOME}/target/site/* /srv/output/