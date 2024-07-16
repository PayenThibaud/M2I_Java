-- Q1
SELECT
	ville_nom,
	ville_population_2012
FROM
	villes_france_free
ORDER BY
	ville_population_2012 DESC
LIMIT
	10;
	
-- Q2
SELECT
	ville_nom,
	ville_surface
FROM
	villes_france_free
ORDER BY
	ville_surface
LIMIT
	50;
	
-- Q3
SELECT
	departement_nom,
	departement_code
FROM
	departement
WHERE
	departement_code LIKE '97%';
	
-- Q4 
SELECT
	ville_nom,
	ville_population_2012,
	departement_nom
FROM
	villes_france_free
LEFT JOIN
	departement ON departement.departement_code = villes_france_free.ville_departement
ORDER BY
	ville_population_2012 DESC
LIMIT
	10;
	
-- Q5
SELECT
	departement_nom,
	departement_code,
	COUNT(ville_id) AS nombre_communes
FROM
	departement
LEFT JOIN
	villes_france_free ON departement.departement_code = villes_france_free.ville_departement
GROUP BY
	departement_nom,
	departement_code
ORDER BY
	nombre_communes DESC; 
	
-- Q6
SELECT
	departement_code,
	departement_nom,
	SUM(ville_surface) AS superficie_departement
FROM
	departement
LEFT JOIN
	villes_france_free ON departement.departement_code = villes_france_free.ville_departement
GROUP BY
	departement_code,
	departement_nom
ORDER BY
	superficie_departement DESC NULLS LAST
LIMIT
	10; 
	
-- Q7
SELECT
	COUNT(ville_nom) AS nom_en_saint
FROM
	villes_france_free
WHERE
	ville_nom LIKE 'SAINT%'; 
	
-- Q8
SELECT
	ville_nom,
	COUNT(*) AS occurence
FROM
	villes_france_free
GROUP BY
	ville_nom
HAVING
	COUNT(ville_nom) > 1
ORDER BY
	occurence DESC;
	
-- Q9
SELECT
	ville_nom,
	ville_surface
FROM
	villes_france_free
WHERE
	ville_surface > (SELECT AVG(ville_surface) FROM villes_france_free)
ORDER BY
	ville_surface DESC;
	
-- Q10
SELECT
	departement_nom,
	SUM(ville_population_2012) AS population_departement
FROM
	departement
LEFT JOIN
	villes_france_free ON departement.departement_code = villes_france_free.ville_departement
GROUP BY
	departement_nom
HAVING
	SUM(ville_population_2012) > 2_000_000
ORDER BY
	population_departement DESC;
	
-- Q11
UPDATE
	villes_france_free
SET
	ville_nom = REPLACE(ville_nom, '-', ' ')
WHERE
	ville_nom LIKE 'SAINT-%';