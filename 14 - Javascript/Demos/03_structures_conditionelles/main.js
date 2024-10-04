// structures conditionelles

// if ... else if .... else

// let age = Number(prompt("Saisir l'age : "))

// console.log(age)

// if ( age < 0 || isNaN(age)){
//     console.log("Age negatif !!!")
// }else if(age < 18) {
//     console.log("Vous etes mineur")
// }else if(age < 255) {
//     console.log("Vous etes majeur")
// }else{
//     console.log("Vous etes tres tres vieux")
// }

// switch..case

// let choix = Number(prompt("Chosir un chiffre entre 1 et 3 : "))

// switch (choix){
//     case 1 :
//         console.log("choix 1");
//         break;
//     case 2 :
//         console.log("choix 2");
//         break;
//     case 3 :
//         console.log("choix 3");
//         break;
//     default:
//         console.log("choix invalide !!!");
//         break;
// }

// // Operateur ternaire

// let isPIGreaterThan4 = Math.PI > 4 ? "Yep" : "Nope";

// console.log(isPIGreaterThan4)

// console.clear()

// // Operateur de coalescence nulle

//let val = null;
let val = 3;
//let val = undefined;
//let val = "coucou";

console.log(val ?? "valeur par défaut")