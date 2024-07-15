-- Q1
CREATE SCHEMA IF NOT EXISTS exercice01;

SET search_path TO exercice01;

-- Q2
CREATE TABLE IF NOT EXISTS personne (
	personne_id INT GENERATED ALWAYS AS IDENTITY,
	titre CHAR(4) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	nom VARCHAR(50) NOT NULL,
	email VARCHAR(255) NOT NULL UNIQUE,
	telephone VARCHAR(10) NOT NULL UNIQUE,
	CONSTRAINT pk_personne_id PRIMARY KEY(personne_id),
	CONSTRAINT chk_titre CHECK(titre IN ('Mr', 'Mme', 'Mlle'))
);

-- Q3
INSERT INTO
	personne
	(prenom, nom, email, telephone, titre) 
VALUES
	('Bob', 'Eponge', 'bob@eponge.fr', '0102030405', 'Mr'),
	('Patrick', 'Etoile', 'patrick@etoile.fr', '0102030406', 'Mr'),
	('Carlos', 'Tentacule', 'carlos@tentacule.fr', '0102030407', 'Mr'),
	('Eugene', 'Krabs', 'eugene@krabs.fr', '0102030408', 'Mr'),
	('Sheldon', 'Plankton', 'sheldon@plankton.fr', '0102030409', 'Mr'),
	('Gary', 'Escargot', 'gary@escargot.fr', '0102030410', 'Mr'),
	('Sandy', 'Ecureuil', 'sandy@ecureuil.fr', '0102030411', 'Mme'),
	('Pearl', 'Krabs', 'pearl@krabs.fr', '0102030412', 'Mlle'),
	('Larry', 'Timothy', 'larry@timothy.fr', '0102030413', 'Mr'); 

SELECT * FROM personne;

-- Q4 
UPDATE
	personne
SET
	prenom = LOWER(prenom),
	nom = UPPER(nom);

-- Q5
DELETE FROM
	personne
WHERE
	personne_id = (SELECT MAX(personne_id) FROM personne);