import { Contact } from "./class/Contact.js";
const contactForm = document.getElementById("contactForm");
const prenomInput = document.getElementById("prenom");
const nomInput = document.getElementById("nom");
const dateNaissanceInput = document.getElementById("dateNaissance");
const emailInput = document.getElementById("email");
const telInput = document.getElementById("tel");
const imageInput = document.getElementById("image");
export const contactsList = [];
let id = 0;
let selectedContactId = null;
contactForm.addEventListener("submit", (event) => {
    event.preventDefault();
    ajouterContact();
});
const deleteButton = document.getElementById("delete");
deleteButton.addEventListener("click", (event) => {
    event.preventDefault();
    supprimerContact();
});
imageInput.addEventListener("change", () => {
    var _a;
    if ((_a = imageInput.files) === null || _a === void 0 ? void 0 : _a.length) {
        afficherImage(imageInput.files[0]);
    }
});
function afficherImage(file) {
    const reader = new FileReader();
    reader.onload = (e) => {
        const profileImage = document.getElementById("profileImage");
        profileImage.src = e.target.result;
    };
    reader.readAsDataURL(file);
}
function ajouterContact() {
    var _a;
    const prenomValue = prenomInput.value;
    const nomValue = nomInput.value;
    const dateNaissanceValue = new Date(dateNaissanceInput.value);
    const emailValue = emailInput.value;
    const telValue = Number(telInput.value);
    const imageFile = ((_a = imageInput.files) === null || _a === void 0 ? void 0 : _a[0]) || null;
    // Créez un nouvel objet Contact
    const nouveauContact = new Contact(prenomValue, nomValue, dateNaissanceValue, emailValue, telValue, ++id, imageFile);
    contactsList.push(nouveauContact);
    contactForm.reset();
    imageInput.value = '';
    updateContactList();
    console.log(contactsList);
}
function supprimerContact() {
    if (selectedContactId !== null) {
        const index = contactsList.findIndex(contact => contact.id === selectedContactId);
        if (index !== -1) {
            contactsList.splice(index, 1);
            selectedContactId = null;
            updateContactList();
        }
    }
}
function updateContactList() {
    const listeDeContactsDiv = document.getElementById('listeDeContacts');
    listeDeContactsDiv.innerHTML = '';
    if (contactsList.length > 0) {
        contactsList.forEach(contact => {
            const boutonRemplir = document.createElement('button');
            boutonRemplir.textContent = `${contact.prenom} ${contact.nom}`;
            boutonRemplir.className = "bouton-contact";
            boutonRemplir.addEventListener('click', () => {
                remplirFormulaire(contact);
                selectedContactId = contact.id;
            });
            listeDeContactsDiv.appendChild(boutonRemplir);
        });
    }
    else {
        listeDeContactsDiv.innerHTML = '<p>Aucun contact</p>';
    }
}
function remplirFormulaire(contact) {
    prenomInput.value = contact.prenom;
    nomInput.value = contact.nom;
    dateNaissanceInput.value = contact.dateNaissance.toISOString().split('T')[0];
    emailInput.value = contact.email;
    telInput.value = contact.tel.toString();
    if (contact.image) {
        afficherImage(contact.image);
    }
    else {
        const profileImage = document.getElementById("profileImage");
        profileImage.src = "./img/imageProfil.png";
    }
}
