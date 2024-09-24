# Build stage
FROM maven:3.8.1-openjdk-17 AS builder

WORKDIR /app

# Copier le fichier pom.xml
COPY pom.xml .

# Télécharger les dépendances en mode hors-ligne
RUN mvn dependency:go-offline

# Copier les sources
COPY src ./src

# Construire l'application sans exécuter les tests
RUN mvn clean package -DskipTests

# Final stage
FROM openjdk:17-jdk

WORKDIR /app

# Copier le fichier JAR généré depuis le build stage
COPY --from=builder /app/target/micro_exo_1-0.0.1-SNAPSHOT.jar .

# Exposer le port 8081
EXPOSE 8081

# Lancer l'application
ENTRYPOINT ["java", "-jar", "micro_exo_1-0.0.1-SNAPSHOT.jar"]
