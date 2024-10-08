let id = 0;

export class Voiture {

    constructor(nom, serie, vitesse){
        this.nom = nom
        this.serie = serie
        this.vitesse = vitesse
        this.id = ++id
    }

    afficher() {
        return `Voiture ${this.id} -> ${this.nom}, ${this.serie}, ${this.vitesse} km/h`;
    }

    accelerer(a){
        this.vitesse += (10 * a);
    }

    tourner(a){
        this.vitesse -= (5 * a);
    }
}
