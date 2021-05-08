FROM maven:3-openjdk-8-slim AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:8-slim
COPY --from=build /usr/src/app/target/hackathon-0.0.1-SNAPSHOT.jar /usr/app/hackathon-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/hackathon-0.0.1-SNAPSHOT.jar"]