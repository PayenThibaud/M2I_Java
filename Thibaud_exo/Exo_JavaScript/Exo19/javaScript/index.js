function compterLettreA(mot) {
    let compteur = 0;

    for (let i = 0; i < mot.length; i++){
        if (mot[i] == "A" || mot[i] == "a"){
            compteur += 1;
        }
    }
    return compteur;
}

alert(compterLettreA("aAaAaerterfgevA"))