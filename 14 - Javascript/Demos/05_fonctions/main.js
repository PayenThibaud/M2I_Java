function sayHello() { // declaration de la fonction
    alert("Hello World !!!")
}

// sayHello(); // appel de la fonction

// console.log(sayHello)

//console.log(sayHello())

// Parametres et Arguments
function sayHelloToSomeone(name){ // 1 parametre name
    alert(`Hello ${name}`)
}

// sayHelloToSomeone("Toto") 
// let myName = "Tata"
// sayHelloToSomeone(myName)

// Parametre par défaut

function sayMessage(from, message = "Aucun texte"){ // message devient facultatif
    alert(`${from} : ${message}`)
}


//sayMessage("Tutu"," bonjour !!!!") // Tutu : bonjour !!!!

// sayMessage("titi") // titi : aucun texte

// Retourner un resultat

function premiereLettre(word){
    return word.charAt(0)
}

//console.log(premiereLettre("Bonjour"));
//console.log(premiereLettre(123));
//console.log(premiereLettre("test"));

function addition(a,b){
    return a + b;
}
// console.log(addition(1,2)); // addition

// // Attention javascript etant faiblement typée, on peut avoir ce genre de chose
// console.log(addition("du ","texte")); // concatenation 

// fonction annonyme, fléchées (lambda, delegates)

// avec la syntaxe function
const sayHi = function (){
    alert("hello from sayHi!!!")
}

//sayHi()

// fonctions fléchées

let sayHi2 = () => alert("hello from sayHi2 !!!!")

//sayHi2()

// const sayHi3 = (name) => {
//     let message = "Bonjour "+name;
//     return message;
// }



const sayHi3 = name => "Bonjour "+name;


//console.log(sayHi3("Toto"))

// CallBack

function salutation(name){
    alert(`Bonjour ${name}`);
}

function processUserInput(callback){
    let name = prompt("Entrez votre nom : ");
    callback(name);
}

//processUserInput(salutation);
// processUserInput(alert);
// processUserInput(console.log);
