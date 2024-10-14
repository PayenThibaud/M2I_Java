// Sélection des éléments du DOM
const contentDiv = document.getElementById('content');
const changeTextBtn = document.getElementById("changeTextBtn");
const contactForm = document.getElementById("contactForm");
const nameInput = document.getElementById("name");
const emailInput = document.getElementById("email");
// Manipulation du contenu
if (contentDiv) {
    contentDiv.innerHTML = "<p>Le texte a été modifié dans TS</p>";
}
// Gestionnaire d'événements pour le bouton
changeTextBtn.addEventListener('click', () => {
    if (contentDiv) {
        contentDiv.innerHTML = "<p>Le texte a été changé dans TS</p>";
    }
});
contactForm.addEventListener("submit", (event) => {
    event.preventDefault();
    const nameValue = nameInput.value;
    const emailValue = emailInput.value;
    console.log(emailValue, nameValue);
});
