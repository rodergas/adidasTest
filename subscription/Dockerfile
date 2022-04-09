FROM adoptopenjdk/openjdk15:alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} subscriptionService.jar
ENTRYPOINT ["java","-jar","/subscriptionService.jar"]