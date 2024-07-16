-- Q1
CREATE USER reader_user WITH PASSWORD 'password';

-- Q2
CREATE ROLE reader;

-- Q3
GRANT SELECT ON ALL tables IN SCHEMA exercice03 TO reader;
GRANT USAGE ON SCHEMA exercice03 TO reader;

GRANT reader TO reader_user;

SELECT * FROM exercice03.departement;

-- Q6
DROP USER reader_user;