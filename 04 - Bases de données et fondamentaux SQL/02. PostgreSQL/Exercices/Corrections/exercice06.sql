-- SELECT

-- Q1
SELECT
	*
FROM
	actor;

-- Q2
SELECT
	last_name
FROM
	actor;

-- Q3
SELECT
	title,
	description,
	rental_duration,
	rental_rate,
	rental_duration * rental_rate AS total_rental_cost
FROM
	film;

-- DISTINCT

-- Q1
SELECT
	DISTINCT last_name
FROM
	actor;

-- Q2
SELECT 
	DISTINCT postal_code 
FROM 
	address;

-- Q3
SELECT 
	DISTINCT rating 
FROM 
	film;

-- WHERE

-- Q1
SELECT
	title,
	description,
	rating,
	length
FROM
	film
WHERE
	length >= (3 * 60);

-- Q2
SELECT
	payment_id,
	amount,
	payment_date
FROM
	payment
WHERE
	CAST(payment_date AS DATE) > '2005-05-27';
	
-- Q3
SELECT
	payment_id,
	amount,
	payment_date
FROM
	payment
WHERE
	CAST(payment_date AS DATE) = '2005-05-27';

-- Q4
SELECT
	*
FROM
	customer
WHERE
	last_name LIKE 'S%'
	AND
	first_name LIKE '%N';
	
-- Q5
SELECT
	*
FROM
	customer
WHERE
	active = 0
	OR
	last_name LIKE '%M';
	
-- Q6
SELECT
	*
FROM
	category
WHERE
	category_id > 4
	AND
	("name" LIKE 'C%' OR "name" LIKE 'S%' OR "name" LIKE 'T%');

-- Q7
SELECT
	staff_id,
	first_name,
	last_name,
	address_id,
	picture,
	email,
	store_id,
	active,
	username,
	last_update
FROM 
	staff
WHERE 
	password IS NOT NULL;
	
-- Q8
SELECT
	staff_id,
	first_name,
	last_name,
	address_id,
	picture,
	email,
	store_id,
	active,
	username,
	last_update
FROM 
	staff
WHERE 
	password IS NULL;

-- IN

-- Q1
SELECT
	phone,
	district
FROM
	address
WHERE 
	district IN ('California','England','Tapei','West Java');

-- Q2
SELECT
	payment_id,
	amount,
	CAST(payment_date AS DATE) AS date_only
FROM 
	payment
WHERE 
	CAST(payment_date AS DATE) IN ('2005-05-25','2005-05-27','2005-05-29');

-- Q3
SELECT 
	*
FROM 
	film
WHERE 
	rating IN ('G','PG-13','NC-17');

-- BETWEEN

-- Q1
SELECT 
	* 
FROM 
	payment
WHERE 
	payment_date BETWEEN '2005-05-25 00:00:00' AND '2005-05-25 23:59:59';

-- Q2
SELECT
	title,
	description,
	release_year,
	rental_duration * rental_rate AS total_rental_cost
FROM
	film
WHERE
	LENGTH(description) BETWEEN 100 AND 120;

-- LIKE

-- Q1
SELECT
	title,
	description,
	release_year
FROM
	film
WHERE
	description LIKE 'A Thoughtful%';

-- Q2
SELECT
	title,
	description,
	release_year
FROM
	film
WHERE
	description LIKE '%Boat';

-- Q3
SELECT
	title,
	description,
	length
FROM
	film
WHERE
	description LIKE '%Database%'
	AND
	length > (3 * 60);

-- LIMIT

-- Q1
SELECT
	*
FROM
	payment
LIMIT 20;

-- Q2
SELECT 
	payment_id, payment_date, amount
FROM 
	payment
WHERE 
	amount > 5
LIMIT 50 OFFSET 51;

-- Q3
SELECT *
FROM customer
LIMIT 100 OFFSET 100;

-- ORDER BY

-- Q1
SELECT 
	*
FROM
	film
ORDER BY 
	"length";

-- Q2
SELECT 
	DISTINCT rating
FROM 
	film
ORDER BY 
	rating DESC;

-- Q3
SELECT
	payment_date,
	amount
FROM
	payment
ORDER BY 
	amount DESC
LIMIT 20;

-- Q4
SELECT
	title,
	description,
	special_features,
	length,
	rental_duration
FROM 
	film
WHERE 
	'Behind the Scenes' = ANY(special_features)
	AND rental_duration BETWEEN 5 AND 7
	AND length < (60 * 2)
ORDER BY 
	length DESC
LIMIT 10;

-- JOIN

-- Q1
SELECT
	c.first_name AS customer_first_name,
	c.last_name AS customer_last_name,
	a.first_name AS actor_first_name,
	a.last_name AS actor_last_name
FROM 
	customer AS c
LEFT JOIN actor AS a ON (c.last_name=a.last_name);

-- Q2
SELECT
	c.first_name AS customer_first_name,
	c.last_name AS customer_last_name,
	a.first_name AS actor_first_name,
	a.last_name AS actor_last_name
FROM 
	customer AS c
RIGHT JOIN actor AS a ON (c.last_name=a.last_name);

-- Q3
SELECT
	c.first_name AS customer_first_name,
	c.last_name AS customer_last_name,
	a.first_name AS actor_first_name,
	a.last_name AS actor_last_name
FROM 
	customer AS c
INNER JOIN actor AS a ON (c.last_name=a.last_name);

-- Q4
SELECT
	city.city,
	country.country
FROM 
	city
LEFT JOIN country ON (city.country_id=country.country_id);

-- Q5
SELECT
	film.title,
	film.description,
	film.release_year,
	language.name AS langue
FROM 
	film
LEFT JOIN language ON (film.language_id=language.language_id);

-- Q6
SELECT
	staff.first_name,
	staff.last_name,
	address.address,
	address.address2,
	address.district,
	address.postal_code,
	city.city
FROM 
	staff
LEFT JOIN address ON (staff.address_id=address.address_id)
LEFT JOIN city ON (address.city_id=city.city_id);

