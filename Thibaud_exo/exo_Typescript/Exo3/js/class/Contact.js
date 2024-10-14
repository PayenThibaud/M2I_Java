export class Contact {
    constructor(p, n, d, e, t, id, image = null) {
        this.prenom = p;
        this.nom = n;
        this.dateNaissance = d;
        this.email = e;
        this.tel = t;
        this.id = id;
        this.image = image;
    }
}
