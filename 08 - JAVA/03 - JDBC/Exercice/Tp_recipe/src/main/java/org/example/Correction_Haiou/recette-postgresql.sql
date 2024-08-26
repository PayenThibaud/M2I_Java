-- Création des tables

CREATE TABLE categorie (
  id SERIAL PRIMARY KEY,
  nom VARCHAR(100) NOT NULL
);

CREATE TABLE ingredient (
  id SERIAL PRIMARY KEY,
  nom VARCHAR(100) NOT NULL
);

CREATE TABLE recette (
  id SERIAL PRIMARY KEY,
  nom VARCHAR(100) NOT NULL,
  temps_prep INT NOT NULL,
  temps_cuisson INT NOT NULL,
  difficulte VARCHAR(100) NOT NULL,
  categorie_id INT NOT NULL, -- PostgreSQL crée automatiquement un index sur les colonnes référencées par une contrainte de clé étrangère, contrairement à MySql. 

  CONSTRAINT fk_recette_categorie FOREIGN KEY (categorie_id) REFERENCES categorie(id)
);

CREATE TABLE etape (
  id SERIAL PRIMARY KEY,
  description TEXT NOT NULL,
  recette_id INT NOT NULL,

  CONSTRAINT fk_etape_recette FOREIGN KEY (recette_id) REFERENCES recette(id) ON DELETE CASCADE
); -- ON DELETE CASCADE, car si une recette est supprimée, toutes les étapes associées à cette recette devront être supprimées automatiquement

CREATE TABLE commentaire (
  id SERIAL PRIMARY KEY,
  description TEXT NOT NULL,
  recette_id INT NOT NULL,

  CONSTRAINT fk_commentaire_recette FOREIGN KEY (recette_id) REFERENCES recette(id) ON DELETE CASCADE
); -- ON DELETE CASCADE, car si une recette est supprimée, tous les commentaires associés à cette recette devront être supprimés automatiquement

CREATE TABLE recette_ingredient (
  id SERIAL PRIMARY KEY,
  recette_id INT NOT NULL,
  ingredient_id INT NOT NULL,

  CONSTRAINT fk_recette_ingredient_recette FOREIGN KEY (recette_id) REFERENCES recette(id) ON DELETE CASCADE,
  CONSTRAINT fk_recette_ingredient_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient(id) ON DELETE CASCADE
); -- ON DELETE CASCADE, car si une recette ou un ingrédient est supprimé, toutes les associations dans recette_ingredient devront être supprimées automatiquement



-- Insertion des données (comme exemple)

INSERT INTO categorie (nom) VALUES
('Entrée'),
('Plat'),
('Désert');

INSERT INTO ingredient (nom) VALUES
('Sucre'),
('Sel'),
('Lait'),
('Oeuf'),
('Farine'),
('Levure'),
('Eau'),
('Beurre'),
('Huile');

INSERT INTO recette (nom, temps_prep, temps_cuisson, difficulte, categorie_id) VALUES
('Omelette', 2, 3, 'Facile', 1);

INSERT INTO etape (description, recette_id) VALUES
('Battre les oeufs.', 1),
('Mettre huile dans une poêle.', 1),
('Versez les oeufs dans la poêle.', 1);

INSERT INTO commentaire (description, recette_id) VALUES
('Très bon.', 1),
('Assez bon, mais un peu trop sucré !', 1),
('Excellente recette que je recommande', 1);

INSERT INTO recette_ingredient (recette_id, ingredient_id) VALUES
(1, 4),
(1, 9);