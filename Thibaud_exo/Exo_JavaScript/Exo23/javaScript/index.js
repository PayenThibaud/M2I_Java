// Tableau des étudiants
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
    }
];

function affichage(etudiants) {
    etudiants.forEach(etudiant => {

        console.log("   Début   etudiant  ")

        console.log("Etudiant: " + etudiant.prenom + " " + etudiant.nom);

        let total = 0;
        let nbNote = 0;

        for (let matiere in etudiant.matieres) {
            console.log("  " + matiere + " = " + etudiant.matieres[matiere]);
            total += etudiant.matieres[matiere];
            nbNote++;
        }

        let moyenne = total / nbNote;

        console.log("Moyenne: " + moyenne);

        console.log("   Fin   etudiant  ")
    });
}

affichage(etudiants);
