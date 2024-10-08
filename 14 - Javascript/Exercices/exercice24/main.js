console.log("exercice 24")

// Recuperation des datas
let nbNotes = Number(prompt("Combien de notes a saisir : "))
let maxNote = 0;
let minNote = 20;
let moyNote = 0;

let result = document.querySelector(".result");

let affichage = `<p> La série contient ${nbNotes} notes : </p> <ul>`



for(let i = 1; i <= nbNotes;i++){
    let noteTmp = Number(prompt("Saisir la note "+i+" : "))
    affichage += `<li>En note ${i}, vous avez saisi ${noteTmp}/20 </li>`
    if(noteTmp < minNote){
        minNote = noteTmp;
    }
    if(noteTmp > maxNote){
        maxNote = noteTmp;
    }
    moyNote += noteTmp;
}

affichage += `</ul> <hr>`
moyNote = moyNote / nbNotes;

console.log("max : "+maxNote);
console.log("min : "+minNote);
console.log("moy : "+moyNote);

affichage += `<p> Sur l'ensemble des ${nbNotes} : </p>
                <ul>
                    <li> La meilleur note est de ${maxNote}/20</li>
                    <li> La moins bone note est de ${minNote}/20</li>
                    <li> La moyenne des note est de ${moyNote}/20</li>
                </ul>
`

// Injection de affichage dans le html
result.innerHTML = affichage