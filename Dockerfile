FROM ubuntu:latest
LABEL authors="dang"
ENTRYPOINT ["top", "-b"]

FROM maven:3.9-eclipse-temurin-22 AS build
COPY ecommerce-backend/src /home/app/src
COPY ecommerce-backend/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean test package

FROM openjdk:22
COPY --from=build /home/app/target/*.jar backend-ecommerce.jar
ENTRYPOINT ["java", "-jar", "/backend-ecommerce.jar"]

EXPOSE 8080

