FROM adoptopenjdk/openjdk15:alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} emailService.jar
ENTRYPOINT ["java","-jar","/emailService.jar"]