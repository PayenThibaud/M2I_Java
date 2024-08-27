## Exercice 1 :

### Parie 1 :

- cree un CRUD sur l'entité Etudiant.

- Etudiant : 
    - Id
    - nom
    - prenom
    - classe


### Partie 2 :

- un étudiant a une seule adresse et une adresse est liée à un seul étudiant
    
- Adresse :
    - numéros
    - rue
    - ville
    - code postal

- Un étudiant aura une liste d'Examens (One to many)
- Examen :
    - date
    - note
    - Matière (string)

- un étudiant pourra suivre plusieurs cours et un cours pourront être suivi par plusieurs étudiants :
- Cours :
    - matière
    - professeur
    - salle
    - horaire


### Bonus : 
- ajouter la recherche d'examens pour un étudiant par matière / par date
- ajouter le calcul de la moyenne d'un étudiant
- ajouter la recherche du cours par matière et par professeur
