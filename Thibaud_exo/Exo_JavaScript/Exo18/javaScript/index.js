function estPalindrome(chaine) {
    const mot = chaine;
    let motRetourner = "";

    for (let i = mot.length - 1; i >= 0; i--) {
        motRetourner += mot[i];
    }

    return mot == motRetourner;
}

alert(estPalindrome("tut"));
alert(estPalindrome("tout"));