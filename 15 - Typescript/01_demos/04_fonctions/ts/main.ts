// Les fonctions en TS sont définies de manière similaire à JS.
// Avec l'ajout de types pour les paramètres et le retour

function add(a: number, b: number): number {
    return a + b
}

let result: number = add(5, 3)
console.log(result);

// Paramètres optionnels

// Les paramètres d'une fonction peuvent être optionnels en utilisant le symbole '?'
// Les paramètre optionnels doivent être placés après les paramètres obligatoires.

function greet(name: string, greeting?: string) : string {
    if (greeting) {
        return `${greeting}, ${name}`
    } else {
        return `Hello, ${name}`
    }
}

console.log(greet("Toto"));
console.log(greet('Tata', "Bonjour"));

// Paramètres avec valeur par défaut

function greet2(name: string, greeting: string = "Hello"): string {
    return `${greeting}, ${name}`
}

// Les fonctions fléchée 

let maFonction = (x: number, y: number) : number => {
    return x + y
}

// function génériques

// Les fonctions génériques permettent de définir des fonctions avec des types dynamiques

function identity<T>(arg: T): T {
    return arg
}

let ouput1 = identity<string>("Hello")
let ouput2 = identity<number>(100)