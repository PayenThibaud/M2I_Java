import { Voiture } from "./class/voiture.js";

const voiture1 = new Voiture("Bmw", "Serie 1", 80);
const voiture2 = new Voiture("Mercedes", "GLB", 100);

console.log(voiture1.afficher());
console.log(voiture2.afficher());

voiture1.accelerer(3);

voiture2.accelerer(2);
voiture2.tourner(2);

const voitureDiv = document.querySelector(".voiture");
voitureDiv.innerHTML += `<div>${voiture1.afficher()}</div>`;
voitureDiv.innerHTML += `<div>${voiture2.afficher()}</div>`;