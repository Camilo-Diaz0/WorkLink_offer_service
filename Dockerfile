FROM eclipse-temurin:24-jre-noble
ARG JAR_FILE=target/offer_service-0.0.1-SNAPSHOT.jar 
COPY ${JAR_FILE} offer_service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/offer_service.jar"]