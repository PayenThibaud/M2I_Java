Bien sûr ! Voici un exercice pratique pour travailler avec les volumes Docker et PostgreSQL.

### Exercice : Utilisation des Volumes Docker avec PostgreSQL

#### Objectif :

Configurer un conteneur PostgreSQL avec Docker en utilisant un volume pour la persistance des données. Vous allez créer une base de données, ajouter des tables et des données, et vérifier la persistance après avoir redémarré le conteneur.

#### Étapes :

1. **Installer Docker** (si ce n'est pas déjà fait).
2. **Créer un volume Docker**.
3. **Démarrer un conteneur PostgreSQL en utilisant le volume**.
4. **Créer une base de données et des tables, puis insérer des données**.
5. **Arrêter et redémarrer le conteneur**.
6. **Vérifier la persistance des données après le redémarrage**.

#### Instructions détaillées :

### Étape 1 : Installer Docker

Assurez-vous que Docker est installé sur votre machine.

### Étape 2 : Créer un volume Docker

Créez un volume nommé `pgdata_exercice` :

```sh
docker volume create pgdata_exercice
```

### Étape 3 : Démarrer un conteneur PostgreSQL en utilisant le volume

Lancez un conteneur PostgreSQL en utilisant le volume `pgdata_exercice` :

```sh
docker run --name my_postgres_exercice -e POSTGRES_PASSWORD=mysecretpassword -v pgdata_exercice:/var/lib/postgresql/data -d postgres
```

### Étape 4 : Créer une base de données, des tables et insérer des données

1. **Entrer dans le conteneur** :

   ```sh
   docker exec -it my_postgres_exercice bash
   ```

2. **Accéder à PostgreSQL** :

   ```sh
   psql -U postgres
   ```

3. **Créer une base de données `school`** :

   ```sql
   CREATE DATABASE school;
   ```

4. **Se connecter à la base de données `school`** :

   ```sql
   \c school
   ```

5. **Créer une table `students`** :

   ```sql
   CREATE TABLE students (
       id SERIAL PRIMARY KEY,
       name VARCHAR(50),
       age INT
   );
   ```

6. **Insérer des données dans la table `students`** :

   ```sql
   INSERT INTO students (name, age) VALUES ('Alice', 20);
   INSERT INTO students (name, age) VALUES ('Bob', 22);
   ```

7. **Vérifier que les données ont été insérées** :

   ```sql
   SELECT * FROM students;
   ```

   Vous devriez voir quelque chose comme :

   ```
    id | name  | age
   ----+-------+-----
     1 | Alice |  20
     2 | Bob   |  22
   ```

8. **Sortir de PostgreSQL et du conteneur** :

   ```sh
   \q
   exit
   ```

### Étape 5 : Arrêter et redémarrer le conteneur

1. **Arrêter le conteneur** :

   ```sh
   docker stop my_postgres_exercice
   ```

2. **supprimer le conteneur** :

   ```sh
   docker rm my_postgres_exercice
   ```

3. **Recreer un conteneur** :

```sh
docker run --name my_postgres_exercice2 -e POSTGRES_PASSWORD=mysecretpassword -v pgdata_exercice:/var/lib/postgresql/data -d postgres
```

### Étape 6 : Vérifier la persistance des données après le redémarrage

1. **Entrer dans le conteneur** :

   ```sh
   docker exec -it my_postgres_exercice2 bash
   ```

2. **Accéder à PostgreSQL** :

   ```sh
   psql -U postgres
   ```

3. **Se connecter à la base de données `school`** :

   ```sql
   \c school
   ```

4. **Vérifier que les données sont toujours présentes** :

   ```sql
   SELECT * FROM students;
   ```

   Vous devriez voir les mêmes données qu'avant le redémarrage :

   ```
    id | name  | age
   ----+-------+-----
     1 | Alice |  20
     2 | Bob   |  22
   ```
