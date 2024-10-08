import { Contact } from "./classe/contact.js";
import maVaribale, {  MY_SERCRET_KEY as myKey } from "./secret_key.js";

console.log(myKey)

console.log(maVaribale)

console.clear()

class Person {

    static count = 0;

    constructor(name){
        this.name = name;
        Person.count++;
    }

    hello() {
        return "Salut je m'appelle "+this.name+"."
    }


}

const maxime = new Person("Maxime");
const teo = new Person("Téo");

console.log(maxime.hello());
console.log(teo.hello());

console.log(Person.count)

let monContact = new Contact()

console.log(monContact)

monContact.afficher();

console.log(monContact.nom)

monContact.prenom = "christophe"

console.log(monContact.prenom)

console.log("getter")
console.log(monContact.name)

console.log(monContact.nom)

monContact.name = "Tata";

console.log(monContact.name)

// Héritage
console.clear()


class Programmer extends Person{
    xp;
    
    hello() {
        return super.hello()+ " et je fait du javascript :-)"
    }
    static drink(){
        return "cofee";
    }
}

const toto = new Programmer("Toto")
console.log(toto.hello())

// static

console.log(Programmer.drink())

console.log(Person.count)