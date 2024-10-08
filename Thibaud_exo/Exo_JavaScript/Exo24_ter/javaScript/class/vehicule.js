export class Vehicule {

    constructor(marque, modele, kilometrage, annee){
        this.marque = marque
        this.modele = modele
        this.kilometrage = kilometrage
        this.annee = annee
    }

    display() {
        return `Marque ${this.marque}, Modele ${this.modele}, Kilometrage ${this.kilometrage}, Annee ${this.annee}`;
    }
}
