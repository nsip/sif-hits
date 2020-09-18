FROM sif-hits-deps AS deps
FROM tomcat:8

RUN mkdir -p /srv/sif/environments/consumer/template/job && \
 mkdir -p /srv/sif/environments/provider/template/job && \
 mkdir -p /srv/sif/environments/provider/template/direct && \
 mkdir -p /srv/src/sif-hits && \
 touch /srv/sif/flyway.properties && touch /srv/sif/hibernate.properties && \
 sed -i 's/shared.loader=/shared.loader=\/srv\/sif\//g' conf/catalina.properties && \
 apt update && \
 apt install -y maven
COPY src /srv/src/sif-hits/src
COPY dist /srv/src/sif-hits/dist
COPY dist/install.sh /srv/src/install.sh
COPY config /srv/src/sif-hits/config
COPY pom.xml /srv/src/sif-hits/pom.xml
COPY dist/${project.artifactId}-${project.version}.war /usr/local/tomcat/webapps/${finalName}.war
COPY dist/templates/consumer/HITS.xml /srv/sif/environments/consumer/template/HITS.xml
COPY dist/templates/provider/HITS.xml /srv/sif/environments/provider/template/direct/HITS.xml
COPY src/main/dist/keystores /srv/sif/keystores
COPY dist/config/environment.properties /srv/sif/environment.properties
COPY dist/log4j.properties /srv/sif/log4j.properties
COPY --from=deps /root/.m2/repository /root/.m2/repository
WORKDIR /srv/src/sif-hits
RUN chmod 700 /srv/src/*.sh && \
  mvn install:install-file -Dfile=/srv/src/sif-hits/dist/sif3-common-${sif3.framework.version}.jar -DgroupId=sif3.framework -DartifactId=sif3-common -Dversion=${sif3.framework.version} -Dpackaging=jar && \
  mvn install:install-file -Dfile=/srv/src/sif-hits/dist/sif3-infra-common-${sif3.framework.version}.jar -DgroupId=sif3.framework -DartifactId=sif3-infra-common -Dversion=${sif3.framework.version} -Dpackaging=jar  && \
  mvn install:install-file -Dfile=/srv/src/sif-hits/dist/sif3-infra-model-${sif3.framework.version}.jar -DgroupId=sif3.framework -DartifactId=sif3-infra-model -Dversion=${sif3.framework.version} -Dpackaging=jar  && \
  mvn install:install-file -Dfile=/srv/src/sif-hits/dist/sif3-infra-rest-${sif3.framework.version}.jar -DgroupId=sif3.framework -DartifactId=sif3-infra-rest -Dversion=${sif3.framework.version} -Dpackaging=jar  && \
  mvn install:install-file -Dfile=/srv/src/sif-hits/dist/sifau-datamodel-${sif3.datamodel.version}.jar -DgroupId=sif3.datamodel -DartifactId=sifau-datamodel -Dversion=${sif3.datamodel.version} -Dpackaging=jar
WORKDIR /usr/local/tomcat
CMD []
ENTRYPOINT ["/srv/src/install.sh"]