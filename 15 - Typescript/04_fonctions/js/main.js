// Les fonctions en TS sont définies de manière similaire à JS.
// Avec l'ajout de types pour les paramètres et le retour
function add(a, b) {
    return a + b;
}
let result = add(5, 3);
console.log(result);
// Paramètres optionnels
// Les paramètres d'une fonction peuvent être optionnels en utilisant le symbole '?'
// Les paramètre optionnels doivent être placés après les paramètres obligatoires.
function greet(name, greeting) {
    if (greeting) {
        return `${greeting}, ${name}`;
    }
    else {
        return `Hello, ${name}`;
    }
}
console.log(greet("Toto"));
console.log(greet('Tata', "Bonjour"));
// Paramètres avec valeur par défaut
function greet2(name, greeting = "Hello") {
    return `${greeting}, ${name}`;
}
// Les fonctions fléchée 
let maFonction = (x, y) => {
    return x + y;
};
// function génériques
// Les fonctions génériques permettent de définir des fonctions avec des types dynamiques
function identity(arg) {
    return arg;
}
let ouput1 = identity("Hello");
let ouput2 = identity(100);
