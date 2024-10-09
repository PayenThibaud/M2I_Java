
function getAverage(array){
    let total = array.reduce((accumulator,currentValue) => accumulator+currentValue);
    return total / array.length;
}

function askForNumberInput(promptMessage,minValue,maxValue = Infinity,promptMessageOnError = "ERREUR, veuillez réessayer  \n"+promptMessage){
    let input;

    input = Number(prompt(promptMessage));

    while(!validateNumberInput(input,minValue,maxValue)){
        input = Number(prompt(promptMessageOnError));
    }
    return input;

}

function validateNumberInput(input,min,max){
    if(input < min || input > max || input === undefined || isNaN(input)){
        return false;
    }else{
        return true;
    }
    
}

function addNote(note,noteArray){
    if(note === undefined){
        note = askForNumberInput("Veuillez entrer une note entre 0 et 20 compris :",0,20)
    }
    noteArray.push(note);

}

function displayMenu(noteArray){
    let inputMode = askForNumberInput(`Choisir un mode de saisie:
1 : Saisie fixe
2 : Saisie jusqu'à note négative `,1,2)

    console.log(`Votre choix : ${inputMode}`)

    switch(inputMode){
        case 1:
        let noteCount = askForNumberInput("Combien de notes ?",1)
        for(let i = 0; i < noteCount; i++){
            addNote(undefined,noteArray)
        }
        break;
        case 2:
        let note;
        while(note !== -1){
            note = askForNumberInput("Note",-1,20)
            if(note !== -1){
                addNote(note,noteArray)
            }
        }
        break;
    }

}

let noteArray = [];

displayMenu(noteArray)

// Calcul et affichage console du max
console.log(`La note maximale est de ${Math.max.apply(null,noteArray)}/ 20`)
// Calcul et affichage console du min
console.log(`La note minimale est de ${Math.min(...noteArray)} / 20`)
// Calcul et affichage console de la moyenne
console.log(`La moyenne est de ${getAverage(noteArray)} / 20`)

