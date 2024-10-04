let pop = parseInt(prompt("Population initiale :"));
let taux = parseFloat(prompt("Taux d'accroissement :")) / 100;
let popVise = parseInt(prompt("Population visée :"));

let nbAn = 0;

for (    ; pop < popVise; pop = pop * (1 + taux)) {
    nbAn++;
}

console.log(nbAn);
