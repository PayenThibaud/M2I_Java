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

-- GROUP BY et fonctions d'agrégations

SELECT
	MAX(salaire) AS salaire_max
FROM
	salaries;

SELECT
	MIN(LENGTH(prenom))
FROM
	salaries;

SELECT
	ROUND(AVG(salaire)) AS salaire_moyen,
	service_id
FROM
	salaries
GROUP BY
	service_id
ORDER BY
	salaire_moyen DESC;

SELECT
	ROUND(AVG(salaire)) AS salaire_moyen,
	service_id
FROM
	salaries
GROUP BY
	service_id
HAVING
	AVG(salaire) > 3000
ORDER BY
	salaire_moyen DESC;

-- Sous requête
-- Une requête peut renvoyer 3 types de résultats
-- 1. Une valeur scalaire (une unique valeur)
-- 2. Une liste de valeur (un tableau à une dimension)
-- 3. Un tableau de valeurs (un tableau à deux dimensions)

-- 1.
SELECT MAX(salaire) FROM salaries;

-- 2.
SELECT prenom FROM salaries;

-- 3.
SELECT prenom, nom FROM salaries;

-- 1.
SELECT
	prenom,
	nom
FROM
	salaries
WHERE
	service_id = (SELECT service_id FROM services WHERE libelle = 'COMMUNICATION');

-- 2.
SELECT
	prenom,
	nom
FROM
	salaries
WHERE
	service_id IN (SELECT service_id FROM services WHERE libelle = 'COMMUNICATION' OR date_creation > '2024-01-01');

-- 3.
SELECT
	prenom,
	nom
FROM
	(SELECT * FROM salaries WHERE service_id = 10) AS communicant
WHERE
	salaire > 1500;

-- Sous requête correlée
-- Elle utilise un élément dans laquelle est elle définie
-- Elle est donc dépendante de son contexte
SELECT
	prenom,
	nom,
	service_id
FROM
	salaries
WHERE
	service_id IN (SELECT service_id FROM services WHERE LENGTH(nom) >= LENGTH(libelle));

-- JOINTURES
SELECT
	prenom,
	nom,
	libelle,
	date_creation
FROM
	salaries
INNER JOIN
	services ON salaries.service_id = services.service_id;

-- JOIN: INNER JOIN par défaut
SELECT
	prenom,
	nom,
	libelle
FROM
	salaries
LEFT JOIN
	services USING(service_id);

-- Jointure naturelle, utilise la colonne similaire entre les deux tables
SELECT
	prenom,
	nom,
	libelle
FROM
	salaries
NATURAL JOIN
	services;


