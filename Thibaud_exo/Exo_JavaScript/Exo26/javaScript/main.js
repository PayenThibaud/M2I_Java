import { Contact } from './class/Contact.js';

const contacts = [];

document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("#formContact");
    const resultTable = document.querySelector("#result");

    form.addEventListener("submit", (e) => {
        e.preventDefault();

        const titre = document.querySelector("input[name='titre']:checked").value;
        const nom = document.querySelector("input[name='nom']").value;
        const prenom = document.querySelector("input[name='prenom']").value;
        const dateNaissance = document.querySelector("input[name='dateNaissance']").value;
        const telephone = document.querySelector("input[name='telephone']").value;
        const email = document.querySelector("input[name='email']").value;

        if (nom !== null && prenom !== null && dateNaissance !== null && telephone !== null && email !== null) {

            const contact = new Contact(titre, nom, prenom, dateNaissance, telephone, email);
            contacts.push(contact);

            resultTable.innerHTML = "";

            contacts.forEach(contact => {
                const tableHTML = document.createElement("tr");
                tableHTML.innerHTML = `
                    <td>${contact.titre}</td>
                    <td>${contact.nom}</td>
                    <td>${contact.prenom}</td>
                    <td>${contact.dateNaissance}</td>
                    <td>${contact.telephone}</td>
                    <td>${contact.email}</td>
                    <td>${contact.id}</td>
                `;
                resultTable.appendChild(tableHTML);
            });

            form.reset();
        }
    });
});
