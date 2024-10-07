function saisirValeur() {
    let tableau = [];
    let espace = "";

    for (let i = 0; i < 10; i++) {
        // let valeur = prompt("entrer le chiffre " + (i + 1));
        let valeur = Math.random()*10;
        tableau.push(valeur);
        console.log(espace + tableau[i]);
        espace += "\t";
    }
}

saisirValeur();
