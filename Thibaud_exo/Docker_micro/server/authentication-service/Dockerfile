# Étape 1 : Construction de l'application
FROM maven:3.9.4-amazoncorretto-11 AS build

# Définit le répertoire de travail pour Maven
WORKDIR /app

# Copie le fichier pom.xml pour télécharger les dépendances
COPY pom.xml /app/

# Copie les fichiers sources du projet
COPY src /app/src

# Compile l'application en skippant les tests
RUN mvn clean package -DskipTests

# Étape 2 : Image d'exécution
FROM amazoncorretto:11

# Définit le répertoire de travail
WORKDIR /app

# Copie le jar de l'étape de build
COPY --from=build /app/target/*.jar /app/authentication-service.jar

# Expose le port de ton service défini dans le .env
EXPOSE ${AUTHENTICATION_SERVICE_PORT}

# Commande pour exécuter l'application avec le profil actif défini
ENTRYPOINT ["java", "-jar", "/app/authentication-service.jar", "--spring.profiles.active=${ACTIVE_PROFILE}"]
