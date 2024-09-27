# Étape 1 : Construction de l'application
FROM maven:3.9.4-amazoncorretto-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : Création de l'image finale
FROM amazoncorretto:11
WORKDIR /app
COPY --from=build /app/target/search-suggestion-service.jar /app/search-suggestion-service.jar
ENTRYPOINT ["java", "-jar", "/app/search-suggestion-service.jar"]
