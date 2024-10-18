## Exercice 1 :

- Créer un nouveau projet Angular
- Créer un composant "counter"
- Intégrer le composant dans app
- Le composant counter doit afficher un compteur qui :
    - commence 0
    - qui est rouge si le nombre est impair et vert si le nombre est pair
    - qui s'incrémente ou se décrémente grâce à 2 boutons.

## Exercice 2 :

- Créer un nouveau composant "series"
- Créer la route du composant series + la route du composant counter
- Créer la barre de navigation
- Dans séries, créer une liste de séries en dur
- Afficher la liste des séries
- Afficher un message si la liste est vide
- Ajouter un bouton de suppression sur chaque élément de la liste

## Exercice 3 :

- Créer un pipe personnalisé qui prend en paramètre un tableau, et un argument de type string 'order' ('asc' ou 'desc')
- Utiliser ce pipe sur le tableau de séries pour le trier
- Ajouter 2 boutons pour modifier l'ordre du tableau (asc, desc)

## Exercice 4 :

- Créer un composant librairie, et sa route
- dans ce composant, afficher une liste de livre
    - title
    - author
    - isRead
- quand le livre est lu, on affiche 👍 et 👎 (windows + . pour ajouter un emoji) s'il n'est pas lu
- Utiliser un pipe perso pour la gestion de l'emoji
- Ajouter un bouton pour marquer un livre lu / pas lu

## Exercice 5 :

- Dans le composant librairie, Créer un fomulaire pour ajouter un livre
- par défaut la valeur de isRead sera false
- Ajouter le nouveau livre à la liste précédente

## Exercice 6 :

- Créer un nouveau composant et sa route
- Dans se composant, créer un formulaire réactif pour créer un pokemon
    - nom
    - description
    - liste de types
    - liste d'attaques
        - nom
        - description
        - dégats
    - zone
        - nom
        - region

## Exercice 7 :

- Reprendre les pokemons
- Créer un composant pokemon-card, ce composant prendra un pokemon via les props et affichera une carte de ce pokemon.
- Afficher ensuite grace à une boucle les pokemons de la liste.

## Exercice 8 :

- Créer un bouton dans le pokemon-card permettant de supprimer un pokemon :
    - Le bouton doit envoyer un événement au parent.
    - Le parent doit récupérer cet événement pour supprimer le pokemon de la liste.

## Exercice 9 :

- Créer un nouveau projet de site e-commerce
    - Gérer des marchandises: ajouter, supprimer, voir dans un tableau d'admin
    - Page d'accueil avec une entête, footer, une grille de mes marchandises
    - On peut ajouter des marchandises dans un panier
    - Une page pour voir le panier
