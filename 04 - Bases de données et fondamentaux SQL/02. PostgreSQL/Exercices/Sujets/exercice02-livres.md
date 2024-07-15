# Utiliser les requêtes SQL

## Objectifs

- Utiliser le langage de manipulation de données
- Comprendre le fonctionnement d'une requête

## Sujet

1. Créer une table nommée « livre » détenant les champs suivant :
   - Id
   - titre
   - auteur
   - editeur
   - date_publication
   - isbn_10
   - isbn_13
2. Exécutez le script d’injection « AjoutLivres.sql » dans la BDD
3. Créer une requête permettant d’afficher les 10 livres les plus anciens (avec toutes les colonnes) classés par ordre croissant
4. Créer une requête permettant d’afficher les 10 livres les plus anciens (seulement l’affichage des colonnes : date_publication, auteur, titre) classés par date de publication croissante
5. Créer une requête permettant d’afficher tous les livres de « Agatha Christie » présent dans la base (à ce stade 3 livres).
6. On nous informe qu’une erreur s’est glissée sur un livre de « Agatha Christie » présent dans la base. En effet, une entrée de la BDD aurait comme auteur « Agatha Christies ». Faites une requête permettant de modifier cette erreur puis exécutez de nouveau la requête de la question 5 afin d’afficher de nouveau le nombre de livre de « Agatha christie » présent dans la BDD (4 à ce stade).
7. Insérer le livre de votre choix dans la BDD en respectant toutes les colonnes.
8. Supprimer le livre de votre choix par les critères d’auteur et titre.
