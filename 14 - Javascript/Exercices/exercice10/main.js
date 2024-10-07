console.log("Exercice 10")

let nbLignes = parseInt(prompt("Entrez la hauteur du triangle : "))

let etoiles = "*"
let espaces = " "
let nbEspaces = nbLignes - 1;

for(let ligne=1;ligne <= nbLignes ; ligne++){
    console.log(`${espaces.repeat(nbEspaces)}${etoiles}`)
    etoiles += "**"
    nbEspaces--
}


// autre solution

let hauteur = parseInt(prompt("Entrez la hauteur du triangle"));

if (!isNaN(hauteur) && hauteur > 0) {
    for (let i = 1; i <= hauteur; i++) {
      let espace = " ".repeat(hauteur - i);
      let etoiles = "*".repeat(2 * i - 1);
      console.log(espace + etoiles);
    }
  }
