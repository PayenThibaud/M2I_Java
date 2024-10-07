let tableau = Array(10);

for(let i = 0;i < tableau.length;i++){
   // tableau[i] = parseInt(prompt("Saisir le  nombre n°:"+(i+1)))
   tableau[i] = (Math.random()*100).toFixed(0)
}


for(let i = 0;i < tableau.length;i++){
    console.log("\t".repeat(i)+tableau[i])
}
