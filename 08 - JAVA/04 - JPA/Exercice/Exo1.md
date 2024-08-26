## Exercice 1 :

### Parie 1 :

- cree un CRUD sur l'entité Etudiant.

- Etudiant : 
    - Id
    - nom
    - prenom
    - classe


### Partie 2 :

- un etudiant a une seul adresse et une adresse est liée a un seul étudiant
    
- Adresse :
    - numeros
    - rue
    - ville
    - code postal

- un etudiant auras une liste de Examens (One to many)
- Examen :
    - Date
    - note
    - matiere (string)

- un etudiant pourras suivre plusieurs cours et un cours pourras etre suivi par plusieur étudiants :
- Cours :
    - matiere
    - profeseur
    - salle
    - horraire

