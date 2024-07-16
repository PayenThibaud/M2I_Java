## 1. Instructions SELECT

- 1a Sélectionner toutes les colonnes de la table actor.
- 1b. Sélectionner uniquement la colonne last_name de la table actor.
- 1c. Sélectionner uniquement les colonnes suivantes de la table film.
  - Nom de la colonne : title, description, rental_duration, rental_rate
  - Note : total_rental_cost est calculé par rental_duration \* rental_rate

## 2. Opérateur DISTINCT

- 2a. Sélectionner tous les noms de famille distincts (différents) de la table actor.
- 2b. Sélectionner tous les codes postaux distincts (différents) de la table address.
- 2c. Sélectionner toutes les classifications distinctes (différentes) de la table film.

## 3. Clause WHERE

- 3a. Sélectionner les colonnes title, description, rating, et movie length de la table films pour les films qui durent 3 heures ou plus.
- 3b. Sélectionner les colonnes payment id, amount, et payment date de la table payments pour les paiements effectués le ou après le 27/05/2005.
- 3c. Sélectionner les colonnes primary key, amount, et payment date de la table payment pour les paiements effectués le 27/05/2005.
- 3d. Sélectionner toutes les colonnes de la table customer pour les lignes ayant un nom de famille commençant par "S" et un prénom se terminant par "N".
- 3e. Sélectionner toutes les colonnes de la table customer pour les lignes où le client est inactif ou a un nom de famille se terminant par "M".
- 3f. Sélectionner toutes les colonnes de la table category pour les lignes où la clé primaire est supérieure à 4 et le champ name commence par "C", "S" ou "T".
- 3g. Sélectionner toutes les colonnes sauf la colonne password de la table staff pour les lignes qui contiennent un mot de passe.
- 3h. Sélectionner toutes les colonnes sauf la colonne password de la table staff pour les lignes qui ne contiennent pas de mot de passe.

## 4. Opérateur IN

- 4a. Sélectionnez les colonnes phone et district de la table address pour les adresses en Californie, en Angleterre, à Taipei ou à Java occidental.
- 4b. Sélectionnez les colonnes payment id, amount et payment date de la table payment pour les paiements effectués le 25/05/2005, le 27/05/2005 et le 29/05/2005.
  - _(Utilisez l'opérateur IN et la fonction DATE, au lieu de l'opérateur AND comme dans les exercices précédents.)_
- 4c. Sélectionnez toutes les colonnes de la table film pour les films classés G, PG-13 ou NC-17.

## 5. Opérateur BETWEEN

- 5a. Sélectionnez toutes les colonnes de la table payment pour les paiements effectués entre minuit le 25/05/2005 et 1 seconde avant minuit le 26/05/2005.
- 5b. Sélectionnez les colonnes suivantes de la table film pour les films dont la longueur de la description est comprise entre 100 et 120.
  - Nom de la colonne : title, description, release_year, total_rental_cost
  - (Note : total*rental_cost est calculé par rental_duration * rental_rate)\*

## 6. Opérateur LIKE

- 6a. Sélectionnez les colonnes suivantes de la table film pour les lignes où la description commence par "A Thoughtful".
  - Title, Description, Release Year
- 6b. Sélectionnez les colonnes suivantes de la table film pour les lignes où la description se termine par le mot "Boat".
  - Title, Description, Rental Duration
- 6c. Sélectionnez les colonnes suivantes de la table film où la description contient le mot "Database" et la durée du film est supérieure à 3 heures.

## 7. Opérateur LIMIT

- 7a. Sélectionnez toutes les colonnes de la table payment et incluez uniquement les 20 premières lignes.
- 7b. Sélectionnez les colonnes id de paiement, date de paiement et montant de la table payment pour les paiements d'un montant supérieur à 5 et sélectionnez uniquement les lignes dont l'indice basé sur zéro dans le jeu de résultats est entre 51 et 100.
- 7c. Sélectionnez toutes les colonnes de la table customer, en limitant les résultats à ceux où l'indice basé sur zéro est entre 101 et 200.

## 8. Instruction ORDER BY

- 8a. Sélectionnez toutes les colonnes de la table film et ordonnez les lignes par le champ length par ordre croissant.
- 8b. Sélectionnez toutes les classifications (ratings) distinctes de la table film et ordonnez-les par classification par ordre décroissant.
- 8c. Sélectionnez les colonnes date de paiement et montant de la table payment pour les 20 premiers paiements, ordonnés par montant du paiement par ordre décroissant.
- 8d. Sélectionnez les colonnes title, description, special features, length, et rental duration de la table film pour les 10 premiers films avec des séquences en coulisses (behind the scenes footage) de moins de 2 heures de durée et une durée de location entre 5 et 7 jours, ordonnés par durée par ordre décroissant.

## 9. JOINTURES

- 9a. Sélectionnez les colonnes prénom/nom de famille du client et prénom/nom de famille de l'acteur en effectuant une jointure à gauche entre la colonne client et la colonne acteur sur la colonne nom de famille dans chaque table. (c.-à-d. `customer.last_name = actor.last_name`)

- 9b. Sélectionnez les colonnes prénom/nom de famille du client et prénom/nom de famille de l'acteur en effectuant une jointure à droite entre la colonne client et la colonne acteur sur la colonne nom de famille dans chaque table. (c.-à-d. `customer.last_name = actor.last_name`)

- 9c. Sélectionnez les colonnes prénom/nom de famille du client et prénom/nom de famille de l'acteur en effectuant une jointure interne entre la colonne client et la colonne acteur sur la colonne nom de famille dans chaque table. (c.-à-d. `customer.last_name = actor.last_name`)

- 9d. Sélectionnez les colonnes nom de ville et nom de pays de la table city, en effectuant une jointure à gauche avec la table country pour obtenir la colonne nom de pays.

- 9e. Sélectionnez les colonnes titre, description, année de sortie et nom de langue de la table film, en effectuant une jointure à gauche avec la table language pour obtenir la colonne "language".

  - Étiquetez la colonne language.name comme "language" (par exemple, `select language.name as language`)

- 9f. Sélectionnez les colonnes first_name, last_name, address, address2, city name, district et postal code de la table staff, en effectuant 2 jointures à gauche avec la table address puis la table city pour obtenir les colonnes liées à l'adresse et à la ville.
