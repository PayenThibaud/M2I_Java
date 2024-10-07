console.log("Exercice 13")

let nombre = parseInt(prompt("Veuillez saisir un entier superieur à 0 : "))

for(let entier = 1; entier < nombre /2 +1;entier++){
    let somme = entier;
    let chaine = `${nombre} = ${entier}`
    for(let j = entier + 1;j< nombre /2 +1;j++){
        somme +=j
        chaine += ` + ${j}`
        if(somme > nombre){
            break;
        }else if(somme === nombre){
            console.log(chaine)
            break;
        }

    }
}