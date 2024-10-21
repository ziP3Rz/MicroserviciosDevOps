# Dockerfile para el servicio de Pedidos

FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/pedidos-service-0.0.1-SNAPSHOT.jar pedidos-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "pedidos-service-0.0.1-SNAPSHOT.jar"]
