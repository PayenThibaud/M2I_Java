console.log("Exercice 12")

let populationInitiale = parseInt(prompt("Saisir population initiale : "))

let tauxAcroissement = parseFloat(prompt("Saisir le taux en pourcentage : "))
tauxAcroissement = tauxAcroissement / 100;

let populationVisee = parseInt(prompt("Saisir population visee : "))

let annee = 0;
let populationActuelle = populationInitiale;

while(populationActuelle < populationVisee){
    populationActuelle *= 1 + tauxAcroissement;
    annee++;
}

console.log("La population dépasse la population visée à l'année "+annee+" ("+Math.round(populationActuelle)+" habitants)")