// Creer un objet , on va utliser la notation accolades
const monObjet = {
    firstName: "John",
    lastName: "Doe"
};

// console.log(monObjet.firstName)

// console.log(monObjet["lastName"])

// PArcourir

// for (const key in monObjet) {
//     console.log(`${key} : ${monObjet[key]}`)
// }


// const maCle = prompt("Quelle clé ?")

// console.log(monObjet.maCle); // non dynamique la clé doit etre explicitement codée.
// console.log(monObjet[maCle]); // dynamique ou maCle peut etre une variable contenant la clé à accéder

// let otherObj = {
//     a:1,
//     b:2,
//     c:3,
// }

// console.log(otherObj)

// console.warn("?. opérateur d'enchaînement optionnel (ou opérateur de nullish coalescing).");

// let user = {
//     name: "Cameron",
//     address: {
//         city: "Tourcoing",
//         postalCode: "59200"
//     }
// };

// let userName = user.name;
// console.log(userName);  // "Cameron"

// let user = null;

// Accès sans vérification - provoque une erreur
// let userName = user.getName();  // TypeError: Cannot read properties of null (reading 'getName')

// let user = null;

// let userName = user?.getName();  // userName sera `undefined`, aucune erreur
// console.log(userName);  // `undefined`




console.warn("Démo THIS");

// const car = {
//     model: "Fiesta",
//     manufacturer: "Ford",
//     fullName: function () {
//         return `${this.manufacturer} ${this.model}`
//     }
// }

// console.warn("This dans une fonction (fonction ())");
// console.log(car.fullName());


// const carArrow = {
//     model: "Fiesta",
//     manufacturer: "Ford",
//     fullName: () => {
//         return `${this.manufacturer} ${this.model}`
//     }
// }

// console.warn("This dans une fonction Arrow (() => )");
// console.log(carArrow.fullName());


//console.warn("Déstructuration d'objets");

// const person = {
//     firstName: 'Tom',
//     lastName: 'Cruise',
//     actor: true,
//     age: 54
// }

// //  const { firstName, age, first } = person //name: Tom, age: 54
// // console.log(firstName);
// // console.log(age);
// // console.log(first);

// const { firstName: nom, age } = person //nom: Tom, age: 54

// console.log(nom);
// console.log(age);




const vegetable = [
    {
        code : 1,
        name : "Carotte",
        price : 1.99
    },
    {
        code : 2,
        name : "Poivron Vert",
        price : 4.99
    },
    {
        code : 3,
        name : "Poivron Rouge",
        price : 4.99
    },
    {
        code : 4,
        name : "Haricot vert",
        price : 3.99
    },
    {
        code : 5,
        name : "Courgette",
        price : 2.5
    },
    {
        code : 6,
        name : "Poivron Jaune",
        price : 4.99
    }
]

// Destructuring

console.log("-----------------Destructuring----------------- ");

const tabNum = [1,2,3];
// console.table(tabNum);

//En ES5
// var a = tabNum[0];
// var b = tabNum[1];



//En ES6 avec le destructuring
// const [a,b] =tabNum;
// console.log("a "+a);
// console.log("b "+b);

// console.table(tabNum);


// let varA = "varA";
// let varB = "varB";

// console.log(`AVANT - varA: ${varA}, varB: ${varB}`);

// [varA, varB] = [varB, varA];

// console.log(`APRES - varA: ${varA}, varB: ${varB}`);

// //Autre exemple avec un tableau associatif

const user = {
    firstname : "Jean",
    lastname : "Dupond",
    age : 35,
    active : false
} 

// En ES5
// var firstname = user.firstname;
// var lastname = user.lastname;

// En ES6 
// const {firstname, lastname, ...userRest} = user;

// console.log(firstname);
// console.log(lastname);
// console.log(userRest);

// // Avec des fonctions
// function getFullName(user){
//     return `${user.firstname} ${user.lastname}`
// }

//  function getFullName({firstname,lastname}){
//      return `${firstname} ${lastname}`
//  }

// console.log(getFullName(user));


// console.log("-----------------rest Operator----------------- ");

//let haricot = vegetable[3]; // crée une réference au tableau n'est pas une vrai copie

// let haricot = {...vegetable[3]}; // une vraie copie car on vient de recréer le tableau associatif (objet) et donc dans ce cas pas de référence

// console.log(haricot);
// console.log(vegetable[3]);
// console.table(vegetable);

// haricot.price = 2.99;

// console.log("Apres modif  haricot")

// console.log(haricot);
// console.log(vegetable[3]); // haricot a modifié le tableau (dans mon premier exemple) car c'est une réference au tableau
// console.table(vegetable);



const tabNum2 = [1,2,3];

const [d,...e] = tabNum2;

console.log(d);
console.log(e);
