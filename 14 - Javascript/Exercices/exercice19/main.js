console.log("Exercice 19")

//premiere solution (for)

// function compterLettreA(chaine) {
//     let compteur = 0;
//     for (let i = 0; i < chaine.length; i++)
//         if (chaine[i] === "a")
//             compteur += 1;
//     return compteur;
// }

// console.log(compterLettreA("abba"));
// console.log(compterLettreA("mixer"));

// deuxieme solution (for of)

// function compterLettreA(chaine) {
//     let compteur = 0;
//     for (let char of chaine)
//         if (char === "a")
//             compteur += 1;
//     return compteur;
// }

// console.log(compterLettreA("abba"));
// console.log(compterLettreA("mixer"));

// amelioration

function compterLettre(chaine, lettre) {
    let compteur = 0;
    for (let char of chaine)
        if (char === lettre)
            compteur += 1;
    return compteur;
}

console.log(compterLettre("abba","a"));
console.log(compterLettre("mixer","x"));