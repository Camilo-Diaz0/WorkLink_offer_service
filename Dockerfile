# Etapa 1: compilar el proyecto
FROM maven:3.9-eclipse-temurin-24 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: imagen final ligera
FROM eclipse-temurin:24-jre-noble
COPY --from=build /app/target/*.jar offer_service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/offer_service.jar"]