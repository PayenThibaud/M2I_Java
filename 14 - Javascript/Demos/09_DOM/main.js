/*
Pour recuperer des elements dans la page HTML , 
on peut utiliser plusieur méthodes disponibles dans l'objet document :
- getElementById()
- getElementsByClassName()
- getElementsByName()

- querySelector()
- querySelectorAll()

*/

/*
// on recupere l'element qui nous interesse :
const monElement = document.getElementById("blabla")

console.log(monElement)


// on vas pouvoir modifier le texte de d'un element HTML
//monElement.innerText = "Je suis un <b>beau paragraphe</b> !!!!"

// si on veux ajouter du html  il faut demander l'evaluation de ces balises par le navigateur
monElement.innerHTML = "Je suis un <b>beau paragraphe</b> !!!!";

const monUl = document.querySelector("#mon-ul")

console.log(monUl)

for (let i = 0;i < 10; i++){
  //  monUl.innerHTML += "<li>Element Suivant</li>"
  // on cree un element avec la methode createElement
  const nouvelLi = document.createElement("li")
  // on ajoute du texte a notre element
  nouvelLi.textContent = "Element "+i
  // on insere dans le dom avec appendChild
  monUl.appendChild(nouvelLi)
}

/*
 Pour declencher des fonctions au clic de l'utilisateur sur un bouton, on peut ajouter l'attribut onclick
et y mettre en valeur l'execution d'une fonction
 */

/*

const clickMonBouton = () => {
    console.log("On a clique sur le Bouton !!!!!!")
}


// On recupere le bouton grace a son id
const monBouton = document.querySelector("#btn-log");

monBouton.addEventListener("click",() => {
    console.log("On a clique sur le second Bouton !!!!!!")
})

monElement.addEventListener("click",() => {
    console.log("On a clique sur le paragraphe !!!!!!")
})

document.querySelector("#mon-input").addEventListener("input",(event) => {
    console.log(event.target.value);
    document.querySelector("#result-input").textContent = event.target.value;
})


const closeButton = document.querySelector("#hide");
const openButton = document.querySelector("#show");
const div = document.querySelector("#my-window");

div.classList.add("hidden")

openButton.addEventListener("click",() => {
   // div.classList.remove("hidden")
    div.classList.toggle("hidden")
})

closeButton.addEventListener("click",() => {
   // div.classList.add("hidden")
    div.classList.toggle("hidden")
})


document.addEventListener("keydown",(e) => {
    console.log(e.key)
    console.log(e.which)
    if(e.key === "Escape"){
        div.classList.toggle("hidden");
    }
})

console.clear()

const form = document.querySelector("#monform");


form.addEventListener("submit", (e) => {
    e.preventDefault();
    console.log("j'ai soumis le formulaire !!!")
    e.target.reset()
})

*/

document.addEventListener("DOMContentLoaded",() => {
    console.log("une fois le DOM chargé")

    document.querySelector("body").style.cssText = `
        background-color : red;
        color: white;
`
})

console.log("des le debut !!!")

