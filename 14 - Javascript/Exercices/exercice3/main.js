console.log("Exercice 03")


let rayon,hauteur,volume;

rayon = Number(prompt("Saisir le rayon : "))
hauteur = Number(prompt('Saisir la hauteur :'))

volume = (Math.PI * rayon**2 * hauteur) / 3

console.log("Le volume est de : "+volume)

console.log("Le volume est de : "+volume.toFixed(2))