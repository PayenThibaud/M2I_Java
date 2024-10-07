console.log("Les tableaux")

//let tab = [];
//let tab = Array(); 


let tab = ["Pomme","Banana",42,true,"Banana",0.5,8]

//console.log(tab)
console.table(tab)

tab.pop() // retirer a la fin

console.table(tab)

tab.shift() // retirer au début

console.table(tab)

// Accer à l'element 3

console.log(tab[2])

// remplacer l'element à l'indice 2
tab[2] = "false";

console.table(tab)

// ajoute un element à un indice non existant

tab[15] = "Mangue"

console.table(tab)

console.log("element à l'indice 1 tab[1] "+tab[1])
console.log("element à l'indice 10 tab[10] "+tab[10])
console.log("element à l'indice 100 tab[100] "+tab[100])

console.table(tab)

console.log(tab.indexOf("Banana")) // premier trouvé qui correspond (===)
console.log(tab.lastIndexOf("Banana")) // dernier trouvé qui correspond (===)


console.clear()

console.table(tab)

// découper un tableau
console.table(tab.splice(2,5)); // decoupe du tableau (renvoie un tableau de la portion coupé) (5 element a partir de l'index 2)
console.table(tab)

//  splice modification du tableau
// slice pas de modification du tableau

// supprimer une valeur directement
delete tab[1]
console.table(tab)

delete tab[10]

console.table(tab)

// filter
console.clear()

console.table(tab)

console.table(tab.filter(val => val))

console.clear()

//let tab1 = ["Pomme","Banana","Banana"]

// let tab3 = tab1.filter(item => item.charAt(0) === "B" )


// console.table(tab1)
// console.table(tab3)


let tab1 = ["Pomme","Banana",42,true,"Banana",0.5,8]

// copier un tableau
let tab2 = [...tab1]; // 2 tableaux différents

let tab3 = tab1; // attention ici nouus avons le meme tableau dans 2 variables (le meme dans la memoire)



tab1.push("toto")

console.log("tab1 : ")
console.table(tab1)
console.log("tab2 : ")
console.table(tab2)
console.log("tab3 : ")
console.table(tab3)


console.clear()


tab1 = ["pomme","orange","ananas","fleur","toto"]

// foreach
tab1.forEach((item,index) => console.log(`${item} ${index}`))

// map
let newTab = tab1.map(val => val.toUpperCase());
console.table(newTab)