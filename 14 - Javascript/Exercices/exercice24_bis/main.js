import { Car } from "./classe/car.js";

let bmw = new Car("BMW","Serie 1",80);
let mercedes = new Car("Mercedes","GLB",100);

const result = document.querySelector("#result");
const result2 = document.querySelector("#result2");
const result3 = document.querySelector("#result3");
const result4 = document.querySelector("#result4");

function createP(vehicule,documentElement){
    documentElement.innerHTML += `<p> La voiture <b> ${vehicule.brand} ${vehicule.model} </b> avance désormais à <b> ${vehicule.speed}km/h </b> </p> `
}

function createPV2(vehicule,domElement,styleClasse){
    domElement.innerHTML += `<p> La Voiture : <span class=${styleClasse}> ${vehicule.brand}, ${vehicule.model} </span> avance désormais à <span class=${styleClasse}> ${vehicule.speed} km/h </span> </p>`
}

function createPV3(vehicule, domElement, styleClasse) {
    // Créer les éléments
    const p = document.createElement('p');
    
    const brandModelSpan = document.createElement('span');
    //brandModelSpan.className = styleClasse;
    brandModelSpan.classList.add(styleClasse)
    brandModelSpan.textContent = `${vehicule.brand}, ${vehicule.model}`;
    
    const speedSpan = document.createElement('span');
    //speedSpan.className = styleClasse;
    speedSpan.classList.add(styleClasse)
    speedSpan.textContent = `${vehicule.speed} km/h`;
    
    p.append('La Voiture : ', brandModelSpan, ' avance désormais à ', speedSpan);
    
    domElement.appendChild(p);
}


bmw.speedUp();
console.log(bmw.toString());
result.innerHTML += bmw;
result.innerHTML += "<br>"
createP(bmw,result2);
createPV2(bmw,result3,"bold")
createPV3(bmw,result4,"red")
bmw.speedUp();
console.log(bmw.toString());
result.innerHTML += bmw.toString();
result.innerHTML += "<br>"
createP(bmw,result2);
bmw.speedUp();
console.log(bmw.toString());
result.innerHTML += bmw.toString();
result.innerHTML += "<br>"
createP(bmw,result2);


mercedes.speedUp();
console.log(mercedes.toString());
result.innerHTML += mercedes.toString();
result.innerHTML += "<br>"
createP(mercedes,result2);
mercedes.speedUp();
console.log(mercedes.toString());
result.innerHTML += mercedes.toString();
result.innerHTML += "<br>"
createP(mercedes,result2);
mercedes.turn();
console.log(mercedes.toString());
result.innerHTML += mercedes.toString();
result.innerHTML += "<br>"
createP(mercedes,result2);
mercedes.turn();
console.log(mercedes.toString());
result.innerHTML += mercedes.toString();
result.innerHTML += "<br>"
createP(mercedes,result2);