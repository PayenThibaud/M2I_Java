export class Contact {
    prenom: string;
    nom: string;
    dateNaissance: Date;
    email: string;
    tel: number;
    id: number;

    constructor(p: string, n: string, d: Date, e: string, t: number, id: number) {
        this.prenom = p;
        this.nom = n;
        this.dateNaissance = d;
        this.email = e;
        this.tel = t;
        this.id = id;
    }
}
