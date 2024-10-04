let rayon = parseInt(prompt("Rayon ?"));
let hauteur = parseInt(prompt("Hauteur ?"));

let result = (Math.PI * rayon**2 * hauteur )/ 3;
result = ( Math.round(result * 100) / 100)

console.log("Result = " + result);

alert("Result = " + result);