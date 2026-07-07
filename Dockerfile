FROM tomcat:10.1
COPY target/ecommerce-app-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ecommerce.war
EXPOSE 8080
CMD ["catalina.sh","run"]
