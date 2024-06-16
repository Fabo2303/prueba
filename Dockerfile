FROM maven:3.9.7-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/sisvita-0.0.1-SNAPSHOT.war /app.war
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.war"]