FROM tomcat:8
MAINTAINER scott.penrose@nsip.edu.au

ADD dist/sifhits-2.10.0.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]
