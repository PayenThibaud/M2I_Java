SET search_path TO entreprise_demo;

------------------------------------
---------- INSERT INTO -------------
------------------------------------

-- Insertion de données dans une table 
INSERT INTO
	-- Nom table
	entreprise_demo.services
	-- 
	(libelle)
VALUES
	('Commercial');

-- Insertion de plusieurs enregistrements
INSERT INTO
	services
	(libelle)
VALUES
	('RH'),
	('Développement');

-- Ajout d'une colonne au format TIMESTAMP
ALTER TABLE
	services
ADD COLUMN date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP;


INSERT INTO
	services
	(libelle, date_creation)  
VALUES
	('Marketing', '2020-10-01 12:00:00');

-- Le format d'un timestamp:
-- 'AAAA-MM-JJ HH:mm:SS'

-- Pour échapper le charactère (') on peut utiliser:
-- ''
-- \'

-- Insertion de données depuis une requête SELECT
INSERT INTO
	services
	(libelle)
SELECT
	'Communication';

-- Permet de récupérer toutes les enregistrements de la table
SELECT * FROM services;

------------------------------------
------------- UPDATE ---------------
------------------------------------

-- Mise à jour d'un enregistrement
-- La clause WHERE permet de filtrer les enregistrements
-- Ici on filtre par rapport à la clé primaire pour être sûr de modifier un enregistrement précis
UPDATE
	services
SET
	libelle = 'Ressources Humaines'
WHERE
	service_id = 2;

-- Sans clause WHERE tous les enregistrements sont modifiés
UPDATE
	services
SET
	libelle = UPPER(libelle);

-- Mise à jour de plusieurs colonnes
UPDATE
	services
SET
	libelle = 'DEVELOPPEMENT',
	date_creation = '"2024-07-15 10:00:15'
WHERE
	service_id = 3;

------------------------------------
------------- DELETE ---------------
------------------------------------

-- /!\ Supprime tous les enregistrements de la table
DELETE FROM
	services

DELETE FROM
	services
WHERE
	service_id = 3;

DELETE FROM
	services
WHERE
	date_creation < '2024-01-01';

TRUNCATE 
	services CASCADE;

