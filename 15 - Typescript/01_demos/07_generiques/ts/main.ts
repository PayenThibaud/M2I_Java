// Fonctions génériques

function identity<T>(arg: T): T {
    return arg
}

// Utilisation de la fonction générique avec différents types
console.log(identity<string>("Hello world"));
console.log(identity<number>(40));

function getFirstElement<T>(arg: T[]): T {
    return arg[0]
}

console.log(getFirstElement<string>(["pomme", "banane", "poire"]));
console.log(getFirstElement<number>([10,20,30]));

// Classes génériques

// Les classes génériques permettent de créer des classes qui fonctionnent avec différents types.

class User<T> {
    content: T
}