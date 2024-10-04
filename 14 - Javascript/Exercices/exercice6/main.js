console.log("Exercice 06")

let age = Number(prompt("Saisir votre age : "))
let salaire = Number(prompt("Saisir salaire attendu : "))
let xp = Number(prompt("Saisir votre experience : "))

if(age < 30){
    console.log("Refus ! age minimum 30 ans")
}else if(xp < 5){
    console.log("Refus ! experience minimum 5 ans")
}else if(salaire > 40000){
    console.log("Refus ! salaire maximum 40000")
}else {
    console.log("Bienvenue !!!!")
}

// deuxieme solution

let boolean = true;

if(age < 30){
    console.log("Refus ! age minimum 30 ans")
    boolean = false;
}

if(xp < 5){
    console.log("Refus ! experience minimum 5 ans")
    boolean = false;
}

if(salaire > 40000){
    console.log("Refus ! salaire maximum 40000")
    boolean = false;
}

if(boolean){
    console.log("Bienvenue !!!!")
}