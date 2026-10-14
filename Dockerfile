FROM tomcat:10.1-jdk21-temurin

LABEL maintainer="Java Jenkins Docker CI/CD Project"

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/app.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
