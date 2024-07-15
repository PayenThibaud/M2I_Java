SET search_path TO entreprise_demo;

-- Sélectionner toutes les colonnes de la table services
SELECT * FROM services;

-- Préciser les colonnes souhaitées
SELECT
	service_id,
	libelle
FROM
	services;

-- Utiliser des alias
-- Utilisation du mot clé AS
-- En l'absence de ce mot clé, l'espace suffit pour mettre un alias
SELECT
	service_id AS id,
	libelle lib
FROM
	services AS s;

-- Utilisation du préfixe de schéma et de table
SELECT
	entreprise_demo.services.libelle
FROM
	services;

-- Utilisation de l'alias de table
SELECT
	service_id,
	s.libelle
FROM
	services s;

INSERT INTO
	salaries (prenom, nom, age, salaire, service_id)
VALUES
	('arthur', 'dennetiere', 25, 1800, 6),
	('jean', 'dupont', 30, 2500, 7),
	('michelle', 'dufour', 21, 1750, 8),
	('léa', 'holludin', 49, 4300, 9),
	('hugo', 'kazorut', 28, 1530, 10); 

-- Impossible de supprimer un élément qui a une référence dans une autre table
-- Il faut ajouter la contrainte CASCADE DELETE lors de la création de la foreign key
DELETE FROM
	services
WHERE
	service_id = 10;

-- On peut lire les enregistrements depuis plusieurs tables
-- En général on préférera utiliser les jointures
SELECT
	*
FROM
	salaries,
	services;

-- WHERE

SELECT
	prenom, 
	nom
FROM
	salaries
WHERE
	salarie_id = 1;

SELECT
	prenom,
	nom,
	age,
	salaire
FROM
	salaries
WHERE
	salaire > 3000
	AND
	age < 50;

SELECT
	prenom,
	nom,
	age,
	salaire
FROM
	salaries
WHERE
	salaire > 2000
	OR
	(age < 35 AND service_id <> 9);

SELECT
	*
FROM
	salaries
WHERE
	age BETWEEN 30 AND 40;

-- LIKE
-- Commence par: 'J%'
-- Fini par: '%e'
-- Contient: '%v%'
-- n'importe quelle lettre: 'a_____'
SELECT
	*
FROM
	salaries
WHERE
	prenom LIKE '%e';

SELECT
	*
FROM
	salaries
WHERE
	salarie_id IN (1, 4);

-- ORDER BY

-- ORDER BY trie de manière croissant par défaut
-- Le mot clé ASC est facultatif
SELECT
	prenom
FROM
	salaries
ORDER BY
	prenom;

-- Trie de manière décroissante
SELECT
	prenom,
	age
FROM
	salaries
ORDER BY
	age DESC;

SELECT
	prenom,
	nom
FROM
	salaries
ORDER BY
	prenom, 
	nom DESC;

-- LIMIT permet de limiter le nombre d'enregistrement que l'on récupère
SELECT
	*
FROM
	salaries
LIMIT
	2;

-- OFFSET permet de créer un décalage sur le jeu d'enregistrement récupéré
SELECT
	*
FROM
	salaries
LIMIT
	2
OFFSET
	2;

INSERT INTO
	salaries
	(prenom, nom, age, salaire, service_id)
VALUES
	('arthur', 'poute', 32, 2500, 10);

-- DISTINCT
-- Supprime les doublons du jeu de résultat
SELECT
	DISTINCT
	prenom
FROM
	salaries;

SELECT
	DISTINCT
	prenom,
	nom
FROM
	salaries;




