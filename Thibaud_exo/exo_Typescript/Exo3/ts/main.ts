import { Contact } from "./class/Contact.js";

const contactForm = document.getElementById("contactForm") as HTMLFormElement;
const prenomInput = document.getElementById("prenom") as HTMLInputElement;
const nomInput = document.getElementById("nom") as HTMLInputElement;
const dateNaissanceInput = document.getElementById("dateNaissance") as HTMLInputElement;
const emailInput = document.getElementById("email") as HTMLInputElement;
const telInput = document.getElementById("tel") as HTMLInputElement;
const imageInput = document.getElementById("image") as HTMLInputElement;

export const contactsList: Contact[] = [];
let id = 0;
let selectedContactId: number | null = null;

contactForm.addEventListener("submit", (event) => {
    event.preventDefault();
    ajouterContact();
});

const deleteButton = document.getElementById("delete") as HTMLButtonElement;
deleteButton.addEventListener("click", (event) => {
    event.preventDefault();
    supprimerContact();
});

imageInput.addEventListener("change", () => {
    if (imageInput.files?.length) {
        afficherImage(imageInput.files[0]);
    }
});

function afficherImage(file: File) {
    const reader = new FileReader();
    reader.onload = (e) => {
        const profileImage = document.getElementById("profileImage") as HTMLImageElement;
        profileImage.src = e.target.result as string;
    };
    reader.readAsDataURL(file);
}

function ajouterContact() {
    const prenomValue = prenomInput.value;
    const nomValue = nomInput.value;
    const dateNaissanceValue = new Date(dateNaissanceInput.value);
    const emailValue = emailInput.value;
    const telValue = Number(telInput.value);
    const imageFile = imageInput.files?.[0] || null;

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
    const listeDeContactsDiv = document.getElementById('listeDeContacts') as HTMLDivElement;
    listeDeContactsDiv.innerHTML = '';

    if (contactsList.length > 0) {
        contactsList.forEach(contact => {
            const boutonRemplir = document.createElement('button');
            boutonRemplir.textContent = `${contact.prenom} ${contact.nom}`;
            boutonRemplir.className = "bouton-contact"

            boutonRemplir.addEventListener('click', () => {
                remplirFormulaire(contact);
                selectedContactId = contact.id;
            });

            listeDeContactsDiv.appendChild(boutonRemplir);
        });
    } else {
        listeDeContactsDiv.innerHTML = '<p>Aucun contact</p>';
    }
}

function remplirFormulaire(contact: Contact) {
    prenomInput.value = contact.prenom;
    nomInput.value = contact.nom;
    dateNaissanceInput.value = contact.dateNaissance.toISOString().split('T')[0];
    emailInput.value = contact.email;
    telInput.value = contact.tel.toString();
    if (contact.image) {
        afficherImage(contact.image);
    } else {
        const profileImage = document.getElementById("profileImage") as HTMLImageElement;
        profileImage.src = "./img/imageProfil.png";
    }
}