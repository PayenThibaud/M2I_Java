# Partie 1

- Création d'un nouveau repo publique
- Choisir un projet spring fonctionelle
- Création de l'architecture pour ajouter des workflows pour votre projet
- Création d'un workflow:
    - Déclencher le workflow lors du push de l'application
    - étape 1: cherchez dans le marketplace l'action pour configurer le jdk
    - étape 2: récupération du projet
    - étape 3: installation des dépendances
    - étape 4: build de l'application

# Partie 2

- Ajouter 2 workflow
    - Créer un workflow qui affiche un message en echo lors d'un fork de votre projet.
    - Créer un workflow qui lors du déclenchement d'une issue envoie un message du type : `Bonjour nom_auteur, nous avons bien pris en compte votre problème du nom de : nom_issue`
    - Utilisez des variables d'environement.

# Partie 3

- Revenir sur le workflow de push pour ajouter:
    - Mise en cache des dépendances
    - Upload d'un artéfact avec le build de notre application.

# Partie 4

- Revenir sur le workflow de push pour ajouter:
    - Upload de l'application uniquement si le push est sur la branche main & si le test à réussit
    - Faire en sorte que le workflow continue même en cas d'echec des tests

# Partie 5

- Création d'un dockerfile pour notre application
- Création d'une image de votre application & push cette image sur dockerhub
- Télécharger votre image en local puis testez la dans un conteneur.