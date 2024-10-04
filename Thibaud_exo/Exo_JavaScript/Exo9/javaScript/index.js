let table = parseInt(prompt("Table de multiplication :"));

for (let i = 1; i < 11; i++) {
    console.log(table + " x " + i + " = " + (table * i));
}

let hor = "|   ";
let ligne = true;
for (let i = 1; i < 11; i++) {

    if (ligne == true && i == 2){
        console.log("- - - - - - - - - - - - - - - - - - - - - - -");
        ligne = false;
        i--;
        continue;
    }

    for (let j = 1; j < 11; j++) {
        hor = hor + (j * i) + "   ";
    }

    console.log(hor);

    hor = "|   "
}