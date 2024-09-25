## Partie 1

- En utilisant votre machine Windows, lancez le service Docker, s’il n’est pas lancé.

- Créer une image Docker sur votre machine du jeu 2048 (voir screen jeux_2048).

```
docker pull oats87/2048
```

- Vérifier que l’image est bien présente sur votre machine.

```
docker images
```

- Lancer ce jeu sur un port disponible au travers d’un conteneur que vous allez appeler «jeu-votre-nom ».

```
docker run -d -p 8080:80 --name jeuToto oats87/2048
```

- Vérifier que le conteneur est bien lancé avec la commande adaptée.

```
docker ps
```

- Créer un second conteneur qui va lancer le même jeu mais avec un nom différent «jeu2-votre-nom ».

```
docker run -d -p 8081:80 --name jeu2Toto oats87/2048
```

- Les 2 jeux sont fonctionnels en même temps sur votre machine, effectuez la commande pour vérifier la présence des conteneurs.

```
docker ps
```

- Ouvrez les 2 jeux sur votre navigateur.

```
http://localhost:8080/
http://localhost:8081/
```

- Stopper les 2 conteneurs et assurez-vous que ces 2 conteneurs sont arrêtés.

```
docker stop jeuToto
docker stop jeu2Toto
docker ps
docker ps -a
```

- Relancez le conteneur «jeu2-votre-nom » et aller vérifier dans votre navigateur s’il fonctionne bien. Effectuez la commande pour voir s’il a bien été relancé. Puis stopper le.

```
docker start jeu2Toto
docker ps
docker stop jeu2Toto
```

- Supprimez l’image du jeu 2048 et les conteneurs associés.

```
docker rm jeuToto
docker rm jeu2Toto
docker rmi oats87/2048
```

- Vérifiez que les suppressions ont bien été faite.

```
docker ps -a
docker images
```