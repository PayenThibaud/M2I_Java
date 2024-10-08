let nbNote = parseInt(prompt("Nombre de note a rentrer"))

let min = 20;
let max = 0;
let moy = 0;

document.getElementById("p").innerText = "Vous avez entré " + nbNote + " notes";


for(let i = 0; i < nbNote; i++){
    let note = parseInt(prompt("note n:" + (i + 1) ));

    if (note < min){
        min = note;
    }

    if (max < note){
        max = note;
    }

    moy += note

    document.getElementById("ul").innerHTML += "<li>En note n°" + (i + 1) + ", vous avez " + note + "/20 </li>";
}

moy = moy/nbNote;

document.getElementById("p2").innerText = "Sur l ensemble des " + nbNote + " notes :"

document.getElementById("ul2").innerHTML += "<li>Moy = " + moy.toFixed(2) + "/20 </li>";
document.getElementById("ul2").innerHTML += "<li>Min = " + min + "/20 </li>";
document.getElementById("ul2").innerHTML += "<li>Max = " + max + "/20 </li>";

