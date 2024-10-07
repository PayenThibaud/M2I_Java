console.log("Exercice 11")

let paper = 0.0001;
let fold = 0;

while(paper <= 400){
    paper *= 2;
    fold++;
}

console.log(fold)

let unfold = 0;
paper = 400;

while(paper >= 0.0001){
    paper /=2;
    unfold++;
}

console.log(unfold);