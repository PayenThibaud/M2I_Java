let id = 0;

export class Contact {

    constructor(titre, nom, prenom, dateNaissance, telephone, email) {
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.email = email;
        this.id = ++id;
    }

    toString() {
        return `Contact ${this.id} -> ${this.titre} ${this.nom} ${this.prenom}, nee le  ${this.dateNaissance}, tel: ${this.telephone}, email: ${this.email}`;
    }
}
