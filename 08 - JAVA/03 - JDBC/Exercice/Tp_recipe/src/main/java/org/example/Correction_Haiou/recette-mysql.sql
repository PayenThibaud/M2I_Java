-- Création des tables

CREATE TABLE categorie (
  id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nom varchar(100) NOT NULL
);

CREATE TABLE ingredient (
  id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nom varchar(100) NOT NULL
);

CREATE TABLE recette (
  id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nom varchar(100) NOT NULL,
  temps_prep int(11) NOT NULL,
  temps_cuisson int(11) NOT NULL,
  difficulte varchar(100) NOT NULL,
  categorie_id int(11) NOT NULL,

  KEY fk_recette_categorie (categorie_id),

  CONSTRAINT fk_recette_categorie FOREIGN KEY (categorie_id) REFERENCES categorie(id)
);

CREATE TABLE etape (
  id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  description text NOT NULL,
  recette_id int(11) NOT NULL,

  KEY fk_etape_recette (recette_id),

  CONSTRAINT fk_etape_recette FOREIGN KEY (recette_id) REFERENCES recette(id) ON DELETE CASCADE
); -- ON DELETE CASCADE, car si une recette est supprimée, toutes les étapes associées à cette recette devront être supprimées automatiquement

CREATE TABLE commentaire (
  id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  description text NOT NULL,
  recette_id int(11) NOT NULL,
  
  KEY fk_commentaire_recette (recette_id),

  CONSTRAINT fk_commentaire_recette FOREIGN KEY (recette_id) REFERENCES recette(id) ON DELETE CASCADE
); -- ON DELETE CASCADE, car si une recette est supprimée, tous les commentaires associés à cette recette devront être supprimés automatiquement

CREATE TABLE recette_ingredient (
  id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  recette_id int(11) NOT NULL,
  ingredient_id int(11) NOT NULL,

  KEY fk_recette_ingredient_recette (recette_id),
  KEY fk_recette_ingredient_ingredient (ingredient_id),

  CONSTRAINT fk_recette_ingredient_recette FOREIGN KEY (recette_id) REFERENCES recette(id) ON DELETE CASCADE,
  CONSTRAINT fk_recette_ingredient_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient(id) ON DELETE CASCADE
); -- ON DELETE CASCADE, car si une recette ou un ingrédient est supprimé, toutes les associations dans recette_ingredient devront être supprimées automatiquement



-- Insertion de données (comme exemple)

INSERT INTO categorie (id, nom) VALUES
(1, 'Entrée'),
(2, 'Plat'),
(3, 'Désert');

INSERT INTO ingredient (id, nom) VALUES
(1, 'Sucre'),
(2, 'Sel'),
(3, 'Lait'),
(4, 'Oeuf'),
(5, 'Farine'),
(6, 'Levure'),
(7, 'Eau'),
(8, 'Beurre'),
(9, 'Huile');

INSERT INTO recette (id, nom, temps_prep, temps_cuisson, difficulte, categorie_id) VALUES
(1, 'Omelette', 2, 3, 'Facile', 1);

INSERT INTO etape (id, description, recette_id) VALUES
(1, 'Battre les oeufs.', 1),
(2, 'Mettre huile dans une poêle.', 1),
(3, 'Versez les oeufs dans la poêle.', 1);

INSERT INTO commentaire (id, description, recette_id) VALUES
(1, 'Très bon.', 1),
(2, 'Assez bon, mais un peu trop sucré !', 1),
(3, 'Excellente recette que je recommande', 1);

INSERT INTO recette_ingredient (id, recette_id, ingredient_id) VALUES
(1, 1, 4),
(2, 1, 9);