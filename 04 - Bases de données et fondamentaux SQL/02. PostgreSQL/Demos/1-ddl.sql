-- DDL : DATA DEFINITION LANGUAGE
-- Pour faire un commentaire, on utilise deux "-" suivi d'un espace.

-- Choisir le schéma à utiliser.
SET search_path TO entreprise_demo;

-- Création d'une base de données :
-- CREATE DATABASE demo01;

-- Suppression d'une base de données : 
-- DROP DATABASE demo01;

-- CREATE <type objet> <nom>;
-- IF NOT EXISTS : Création de la BDD uniquement si elle n'existe pas !
CREATE SCHEMA IF NOT EXISTS entreprise_demo;

-- Suppression du schéma
-- DROP SCHEMA IF EXISTS entreprise_demo;

----------------------------------------
------------ CREATE TABLE --------------
----------------------------------------

-- Pour créer une table, on utilise l'instruction CREATE TABLE
-- On peut vérifier que la table n'existe pas avant de la créer
-- Pour être sûr de créer la table au bon endroit, on peut préfixer du schéma
CREATE TABLE IF NOT EXISTS services (
	-- <nom de l'attribut> <type> <contraintes>
	service_id SERIAL PRIMARY KEY,
	libelle VARCHAR(50)
);

-- Suppression d'une table si elle existe :
-- DROP TABLE IF EXISTS entreprise_demo.services;


CREATE TABLE IF NOT EXISTS salarie (
	-- Fait la même chose que SERIAL, c'est à dire créer un Id unique automatiquement
	-- Respecte au mieux la convention SQL
	salarie_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	-- On précise NOT NULL, par défaut la valeur peut être null
	prenom VARCHAR(50) NOT NULL,
	nom VARCHAR(50) NOT NULL,
	-- La contrainte check permet d'ajouter un mécanisme de vérification
	"age" INT NOT NULL CHECK("age" > 18 AND "age" < 65),
	-- La contrainte default permet de définir une valeur par défaut en cas d'absence de valeur renseigné
	salaire DECIMAL(6,2) DEFAULT 1500,
	service_id INT NOT NULL,
	-- Contrainte qui permet de lier la colonne service_id à la table à laquelle elle fait référence
	CONSTRAINT fk_service_id FOREIGN KEY(service_id) 
	REFERENCES entreprise_demo.services(service_id)
);

-- Modification d'une table
-- ALTER TABLE entreprise_demo.salarie RENAME TO salaries;

-- Suppression d'une colonne
ALTER TABLE salaries
	DROP COLUMN salaire;

-- Renommer une table
ALTER TABLE salarie RENAME TO salaries;

-- Nommage de contraintes 
-- pk_table_id: clé primaire
-- fk_table_id: clé étrangère
-- chk_contrainte: check
-- ux_contrainte: clé unique
-- idx_contrainte: index

