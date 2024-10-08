console.log("Exercice 14")

// premiere solution

function nomPrenom(nom,prenom){
    return nom+" "+prenom
}

let message = nomPrenom("toto","tata")
console.log(message)

// deuxieme solution

function nomPrenom2(nom,prenom){
    nom = nom.charAt(0).toUpperCase()+ nom.substring(1).toLowerCase()
    prenom = prenom.charAt(0).toUpperCase()+ prenom.substring(1).toLowerCase()
    return nom+" "+prenom
}

console.log(nomPrenom2("tOTo","TATA"))


// troisieme solution

function toTitle(text){
    return text[0].toUpperCase() + text.substring(1).toLowerCase();
}

function nomPrenom3(nom,prenom){
    return toTitle(nom)+ " "+toTitle(prenom)
}

console.log(nomPrenom3("toTo","TATA"))