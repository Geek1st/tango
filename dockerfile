FROM tomcat:8.5.38-jre8
MAINTAINER shen_zq "shen_zq@centit.com"
COPY $PWD /usr/local/tomcat/webapps/tango
EXPOSE 8080
