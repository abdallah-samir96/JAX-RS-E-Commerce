FROM maven:3.8.8-eclipse-temurin-11 AS build

LABEL author="Abdullah Samir"

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src  ./src
RUN mvn clean package -DskipTests



#Stage 2

FROM tomcat:10.0.0-M4-jdk11-adoptopenjdk-openj9

RUN rm -rf /usr/local/tomcat/webapps/*

ENV SERVICE_NAME=e-commerce-simple-app
COPY --from=build /app/target/e-commerce.war /usr/local/tomcat/webapps/e-commerce.war

EXPOSE 8080


ENTRYPOINT ["catalina.sh", "run"]