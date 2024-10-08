let etudiants = [ 
    { 
        prenom: "José", 
        nom: "Garcia", 
        matieres: { 
            francais: 16, 
            anglais: 7, 
            humour: 14 
        }  
    }, 
    { 
        prenom: "Antoine", 
        nom: "De Caunes", 
        matieres: { 
            francais: 15, 
            anglais: 6, 
            humour: 16, 
            informatique: 4, 
            sport: 10 
        } 
    }, 
    { 
        prenom: "Toto", 
        nom: "Tata", 
        matieres: { 
            francais: 15, 
            humour: 16, 
            informatique: 4, 
            sport: 10,
            math : 20
        } 
    }
]; 

// Parcourir mon tableaux d'etudiants

let somme = 0;
let nbrNote = 0;
let moyenne = 0;

for (const etudiant of etudiants){
   // console.log(etudiant)
   console.log("######### DEBUT ETUDIANT ########");
   console.log(`Etudiant : ${etudiant.nom} ${etudiant.prenom}`);
   for (const key in etudiant.matieres) {
        console.log(`${key} : ${etudiant.matieres[key]}/20`);
        somme += etudiant.matieres[key];
        nbrNote++;
   }
   moyenne = somme/nbrNote;
   console.log("La moyenne est de "+ moyenne.toFixed(2))
   somme = 0;
   nbrNote = 0;
   console.log("######### FIN ETUDIANT ########");
}