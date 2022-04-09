FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} email.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/email.jar"]