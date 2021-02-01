FROM openjdk:8-jdk


ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/application.jar

EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/share/application.jar"]