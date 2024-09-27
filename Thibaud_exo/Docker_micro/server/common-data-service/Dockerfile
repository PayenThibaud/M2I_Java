# Étape 1 : Utiliser une image Maven avec JDK 11 pour construire le projet
FROM maven:3.6.3-jdk-11 AS build

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier les fichiers pom.xml et télécharger les dépendances nécessaires
COPY pom.xml .
RUN mvn dependency:go-offline

# Copier tout le reste du projet et construire l'application
COPY src ./src
RUN mvn package -DskipTests

# Vérifier le contenu du répertoire target
RUN ls -la /app/target

# Étape 2 : Utiliser une image légère de JRE 11 pour exécuter l'application
FROM openjdk:11-jre-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le JAR généré à partir de l'étape précédente
COPY --from=build /app/target/*.jar app.jar

# Exposer le port défini dans le fichier .env
EXPOSE ${PORT}

# Commande pour lancer l'application avec les variables d'environnement
CMD ["java", "-jar", "app.jar"]
