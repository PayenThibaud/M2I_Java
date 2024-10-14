// Sélection des éléments du DOM
const contentDiv = document.getElementById('content') as HTMLDivElement
const changeTextBtn = document.getElementById("changeTextBtn") as HTMLButtonElement
const contactForm = document.getElementById("contactForm") as HTMLFormElement
const nameInput = document.getElementById("name") as HTMLInputElement
const emailInput = document.getElementById("email") as HTMLInputElement

// Manipulation du contenu
if(contentDiv) {
    contentDiv.innerHTML = "<p>Le texte a été modifié dans TS</p>"
}

// Gestionnaire d'événements pour le bouton
changeTextBtn.addEventListener('click', () => {
    if(contentDiv) {
        contentDiv.innerHTML = "<p>Le texte a été changé dans TS</p>"
    }
})

contactForm.addEventListener("submit", (event) => {
    event.preventDefault()

    const nameValue = nameInput.value
    const emailValue = emailInput.value

    console.log(emailValue, nameValue);
})