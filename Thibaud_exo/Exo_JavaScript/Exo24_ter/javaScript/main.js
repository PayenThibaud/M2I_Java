import { Voiture } from './class/Voiture.js';
import { Moto } from './class/Moto.js';

const voiture1 = new Voiture("Renault", "Kangoo", 240000, 2054, "Climatisee");
const moto1 = new Moto("BMW", "R1150R", 65000, 2005);

console.log(voiture1.display());
console.log(moto1.display());


const vehiculDiv = document.querySelector(".vehicule");
vehiculDiv.innerHTML += `<div>${voiture1.display()}</div>`;
vehiculDiv.innerHTML += `<div>${moto1.display()}</div>`;