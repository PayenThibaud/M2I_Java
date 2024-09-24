1. **Création d'un container Alpine :**

   - Utilisez la commande Docker pour créer un container basé sur l'image Alpine.
   - Connectez-vous au shell du container nouvellement créé.

```bash
docker pull alpine
docker run -it --name exercice_conteneur_1 alpine
```

2. **Récupération d'un dépôt GitHub :**

   - À l'intérieur du container, utilisez la commande `git` pour cloner un dépôt public depuis GitHub (par exemple, https://github.com/votre-utilisateur/exemple-repo.git).
   - Allez dans le répertoire du dépôt cloné.

```bash
apk update
apk upgrade
apk add git
apk add nano
git clone https://github.com/Swanndolia/formation-test
cd formation-test
nano README.md
```
