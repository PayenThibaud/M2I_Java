for (let i = 0; i < 1; i++) {
    let salaire = parseInt(prompt("Votre salaire :"));
    if (salaire > 40001) {
        alert("Salaire max est 40 000")
        break
    }

    let age = parseInt(prompt("Votre age :"));
    if (age < 29) {
        alert("Age min 30 ans");
        break
    }

    let nbExp = parseInt(prompt("Combien d'années d'expérience :"));
    if(nbExp < 4) {
        alert("Min 5 ans d experience")
        break
    }

    alert("Profil retenu")
}