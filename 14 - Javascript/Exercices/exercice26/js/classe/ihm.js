import Contact from "./contact.js";

export class Ihm {
    constructor(formulaire,tableauHtmlResultat){
        this.contacts = [];
        this.formulaire = formulaire;
        this.tableauHtmlResultat = tableauHtmlResultat;
    }


    demarrer(){
        this.formulaire.addEventListener("submit",(e) =>{
            e.preventDefault();
            console.log("1- recuperation des input")
            console.log("2- cree un contact avec les value des input")
            console.log("3- ajouter le contact a mon tableeau contacts")
            console.log("4- rafraichir mon tableau html de contacts")
            this.ajoutContact();
        })
    }

    ajoutContact(){
        //1- recuperation des input
        const nom = this.formulaire.querySelector("input[name='nom']").value;
        const prenom = this.formulaire.querySelector("input[name='prenom']").value;
        const telephone = this.formulaire.querySelector("input[name='telephone']").value;
        const email = this.formulaire.querySelector("input[name='email']").value;
        const dateNaissance = this.formulaire.querySelector("input[name='dateNaissance']").value;
        const titre = this.formulaire.querySelector("input[name='titre']:checked").value;
        // 2- cree un contact avec les value des input
        const contact = new Contact(nom,prenom,titre,email,telephone,dateNaissance);
        // 3- ajouter le contact a mon tableeau contacts
        this.contacts.push(contact);
        console.table(this.contacts);
        this.updateTableau();
        this.formulaire.reset();
    }


    // 4- rafraichir mon tableau html de contacts
    updateTableau(){
        console.log("refresh du tableau");
        this.tableauHtmlResultat.innerHTML = "";
        this.contacts.forEach((contact,index)=> {
            this.tableauHtmlResultat.innerHTML += `
            <tr>
                <td>${contact.titre}</td>
                <td>${contact.nom}</td>
                <td>${contact.prenom}</td>
                <td>${contact.dateNaissance}</td>
                <td>${contact.telephone}</td>
                <td>${contact.email}</td>
            </tr>
            `  
        })
    }
}