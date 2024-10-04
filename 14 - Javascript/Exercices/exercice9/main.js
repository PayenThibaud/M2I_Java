console.log("Exercice 09")

let n = Number(prompt("Saisir n :"))

if(n > 0 && !isNaN(n)){
    for(let table = 1; table <=n;table++){
        console.log(`\nTable des ${table} :`)
        for(let mul = 1;mul <=10;mul++){
            console.log(`${table} x ${mul} = ${table*mul}`)
        }
    }
}else{
    alert("valeur de n incorrect !!!")
}

// solution pour second affichage

let max = parseInt(prompt("Please enter a number:"));

console.log("______");

// deuxième affichage
let line = "";
console.log(" 1 2 3 4 5 6 7 8 9 10");
console.log("---------------------");
for (i = 1; i < max+1; i++) {
    for (j = 1; j < 11; j++) {
        line += " " + i*j;
    }
    console.log(line);
     line = "";
}
