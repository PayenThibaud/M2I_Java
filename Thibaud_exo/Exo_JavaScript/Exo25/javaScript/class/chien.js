let id = 0;

export class Chien {

    constructor(nom, race, age) {
        this.id = ++id;
        this.nom = nom;
        this.race = race;
        this.age = age;
    }

    display() {
        return `Chien { Id ${this.id}, Nom ${this.nom}, Race ${this.race}, Age ${this.age} }`;
    }
}
