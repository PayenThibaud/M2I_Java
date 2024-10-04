console.log("Je suis dans main.js !!!!")

// un commentaire sur une ligne

/*
Un commentaire
sur plusieurs 
lignes
*/

// Interaction :

//alert("Bonjour M2I !!")

console.log("Bonjour M2I !!")
console.error("Une erreur !!!")
console.info("Atention !!!")
console.warn("Un warning !!")


// Variables

// var : (ES5) EcmaScript 5

var maVariable = "Salut à tous !!!"

console.log(maVariable)

console.log(typeof maVariable)


console.log(maVariable)

maVariable = 42;



console.log(typeof maVariable)

// const (ES6)

const PI = 3.14;

console.log(PI)

//PI = 3.141


console.log(PI)

// let (ES6)

let maVariableLet; //declaration

console.log(maVariableLet) // undefined

console.log("type de ma variable maVariableLet "+ typeof maVariableLet)

maVariableLet = "Salut" // Assignation

console.log(maVariableLet) 

console.log("type de ma variable maVariableLet "+ typeof maVariableLet)

let boolean = true
boolean = false

console.log("type de ma variable boolean "+ typeof boolean)

let maVariableNull = null

console.log("type de ma variable maVariableNull "+ typeof maVariableNull)


console.clear() // nettoyage de la console

// Interaction
// prompt

let maVar;

maVar = prompt("Taper une valeur : ")

console.log(maVar)

console.log(typeof maVar)

let nbr = parseInt(maVar)

console.log(nbr)

console.log("Utilisation de parseInt")

console.log(typeof nbr)

let nbr2 = Number(maVar)

console.log("Utilisation de Number")

console.log(nbr2)

console.log(typeof nbr2)

console.log("apres mon prompt")

