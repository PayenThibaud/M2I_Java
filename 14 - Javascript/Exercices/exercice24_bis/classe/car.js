export class Car {
    constructor(brand,model,speed){
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }

    speedUp(){
        this.speed += 10;
    }

    turn(){
        this.speed -= 5;
    }

    toString(){
        return `La voiture ${this.brand} ${this.model} avance désormais à ${this.speed}km/h`
    }
}