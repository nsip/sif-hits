#!/bin/bash
if [ -z "$1" ]; then
	echo "Create a new empty database in this environment. Either on the command line or through the dashboard."
	echo "Then run this script with the Application Key as the only argument."
	echo "eg."
	echo "   ./dist/test.sh 90c59ecb9bb84db19d52500bcd02ae5c"
	exit 0
fi
SIF_HOME=/var/sif/hitsprovider
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
cd $DIR/..
echo "Backing up test resources"
cp -R ${DIR}/../src/test/resources ${DIR}/../src/test/resbak
echo "Copying resources from sif home"
cp -R ${SIF_HOME}/environment.properties ${DIR}/../src/test/resources/
cp -R ${SIF_HOME}/log4j.properties ${DIR}/../src/test/resources/
cp ${SIF_HOME}/consumers/TestConsumer.properties ${DIR}/../src/test/resources/TestConsumer.properties
cat ${SIF_HOME}/hibernate/sif3infra.hibernate.properties | grep -v c3p0 >  ${DIR}/../src/test/resources/sif3infra.hibernate.properties
sed -i 's/^log4j.appender.file.*//' ${DIR}/../src/test/resources/log4j.properties
sed -i 's/^log4j.rootLogger.*/log4j.rootLogger=ERROR, stdout/'  ${DIR}/../src/test/resources/log4j.properties
sed -i 's/DEBUG/ERROR/' ${DIR}/../src/test/resources/log4j.properties
sed -i 's/INFO/ERROR/' ${DIR}/../src/test/resources/log4j.properties
sed -i 's/WARN/ERROR/' ${DIR}/../src/test/resources/log4j.properties
echo "Setting current environment: $1"
sed -i "s/^env.application.key=.*/env.application.key=$1/" ${DIR}/../src/test/resources/TestConsumer.properties
sed -i "s/^env.userToken=.*/env.userToken=$1/" ${DIR}/../src/test/resources/TestConsumer.properties
sed -i "s/^env.pwd=.*/env.pwd=$1/" ${DIR}/../src/test/resources/TestConsumer.properties
echo "Executing tests ... Note: this will take a couple of minutes, don't panic"
mvn -q -Dtest=ConsumerTests -DskipTests=false test
echo "Restoring backed up test resources"
rm -Rf ${DIR}/../src/test/resources
mv ${DIR}/../src/test/resbak ${DIR}/../src/test/resources
