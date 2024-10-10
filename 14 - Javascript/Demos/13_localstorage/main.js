// enregistrer une donee dans le localstorage
// key = valeur
//localStorage.setItem("username","toto");

// Recup une donee dans le localstorage
let username = localStorage.getItem("username")
console.log(username) // toto

// Suppr une donee dans le localstorage
localStorage.removeItem("username")

localStorage.setItem("username","toto");
localStorage.setItem("config","tata");

// Vider le localstorage
localStorage.clear();

// objet
let user = {
    firstName: "Toto",
    lastName: "Tata"
}

// Convertir l'objet en chaine JSON et le stocker
localStorage.setItem("user",JSON.stringify(user));

// Recup de la chaine json depuis le localstorage
localStorage.getItem('user');


console.log(localStorage.getItem('user'));

// Convertir la chaine json reup
let userObject = JSON.parse(localStorage.getItem('user'))

console.log(userObject);

