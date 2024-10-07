function tableauPairImpaire() {
    const taille = parseInt(prompt("Taille du tableau"));
    let tableau = [];

    for (let i = 0; i < taille; i++) {
        let valeur = Math.round(Math.random() * 50) + 1;
        tableau.push(valeur);
    }

    tableau.forEach(nombre =>
         (nombre % 2 === 0) ?
            console.log("Le nombre " + nombre + " est   pair ")
        :
            console.log("Le nombre " + nombre + " est   impair ")
    );
}

tableauPairImpaire();
