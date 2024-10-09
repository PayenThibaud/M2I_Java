import { Vehicule } from "./vehicule.js";


export class Moto extends Vehicule {

    display(){
        return "Moto : "+super.display();
    }
}