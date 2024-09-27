# Étape de construction
FROM node:14 AS build

# Définir le répertoire de travail
WORKDIR /app

# Copier les fichiers de dépendances
COPY package.json yarn.lock ./

# Installer les dépendances avec Yarn
RUN yarn install

# Copier le reste des fichiers
COPY . .

# Construire l'application
RUN yarn run build

# Étape de production
FROM node:14 AS production

# Définir le répertoire de travail
WORKDIR /app

# Copier les fichiers construits
COPY --from=build /app/build ./build
COPY server.js ./

# Installer Express
RUN yarn add express

# Exposer le port
EXPOSE 3000

# Démarrer l'application
CMD ["node", "server.js"]
