let hauteur = parseInt(prompt("hauteur du triangle :"));

let hor = "";
let etoile = "";

for (let i = 0; i < hauteur; i++) {

    for (let j = 0; j < hauteur - i ; j++) {
        hor += " ";
    }

    if(i == 0) {
        etoile = etoile + "*"
    } else {
        etoile += "**";
    }

    console.log(hor + etoile);

    hor = "";
}

