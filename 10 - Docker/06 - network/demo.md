1. Création d'un réseau personnalisé

```bash
docker network create my_network
```

2. Création de deux conteneurs sur un même réseau

```bash
docker run -d --name container1 --network my_network nginx
docker run -d --name container2 --network my_network nginx
```

3. Se connecter à container1

```bash
docker exec -it container1 /bin/bash
apt update
apt-get install -y iputils-ping
# Test de la connectivité vers container2 depuis container1
ping container2
```
