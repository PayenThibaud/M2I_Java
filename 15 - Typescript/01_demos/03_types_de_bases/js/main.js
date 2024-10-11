// Types primitifs
// number
// Typescipt utilise le type number pour les nombres. Il peut s'agir de nombres entiers ou à virgule.
let age = 30;
let pi = 3.14;
let hex = 0xf00d; // Hexadécimal
let binary = 0b1010101; // Binaire
// string
// Le type string est utilisé pour les chaînes de caractères.
let firstname = "Toto";
// boolean
// Le type boolean ne peut avoir que deux valeurs : true ou false
let isDone = false;
let isLoggedIn = true;
// void
// Le type void est souvent utilisé pour indiquer qu'une fonction de retourne rien
function printMessage(message) {
    console.log(message);
}
// any
// Le type any permet de désactiver le typage pour une variable
// Cela peut être utile quand on veut utiliser une variable sans connaître son type exacte à l'avance
let randomValue = 10;
randomValue = 'Hello';
// null et undefined
// Ces deux types représentent l'absence de valeur.
let a = undefined;
let b = null;
// Types complexes
// array
// Les tableaux peuvent être typés pour contenir certain type de données.
let list = [1, 3, 2, 5, 8, 10];
let fruits = ["Pomme", "Poire"];
let autreList = [1, 2, 3, 4];
// tuple
// Les tuples permettent de créer des tableaux de taille fixe avec un type spécifiques pour chaque élément.
let person;
person = ["john", 30, "Doe"];
// enum
// Les énumérations (enum) permettent de définir un ensemble de valeurs.
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Blue"] = 2] = "Blue";
})(Color || (Color = {}));
let color = Color.Red;
// unknown
// Le type unknown est similaire à any, mais en plus sécurisé
// Avant d'utiliser une variable de type unknown, il faut faire une vérification de type
let varA = 4;
varA = "Hello world";
// varA.toUpperCase() // erreur
if (typeof varA === "string") {
    console.log(varA.toUpperCase()); // On peut utiliser la variable comme une chaine de caractère
}
