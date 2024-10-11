const select = document.getElementById('dog-select');
const btn = document.getElementById('btn-submit');
const output = document.getElementById('selectOutput');



let myDogs = [
    {
        name: "Rantanplan",
        breed: "Berger texan",
        age: 7
    },
    {
        name: "Rex",
        breed: "Berger allemand",
        age: 5
    }
]

// premiere partie : construction du select avec les chiens contenu dans myDogs

// Ajouter les oprions au select
const refreshDogSelect = () => {
    select.innerHTML = '<option value="0">Sélectionnez votre chien</option>'
    myDogs.forEach((dog,index) => {
        select.innerHTML +=  `<option value="${index+1}">${dog.name}</option>`
    })
    
}

refreshDogSelect();


// deuxieme partie : recuperation des donnee du formulaire et ajout d'un chien au tableau myDogs avec ces données

btn.addEventListener("click",() => {
    let dogName = document.getElementById('dog-name').value;
    let dogBreed = document.getElementById('dog-breed').value;
    let dogAge = document.getElementById('dog-age').value;

    console.log(dogName);
    console.log(dogBreed);
    console.log(dogAge);

    myDogs.push({
        name: dogName,
        breed:dogBreed,
        age: dogAge
    })

    console.table(myDogs);
    refreshDogSelect();

   document.getElementById('dog-name').value = "";
   document.getElementById('dog-breed').value = "";
   document.getElementById('dog-age').value = "";
})

select.addEventListener("change",() => {
   // console.log("j'ai utilise mon select");
    let dogId = select.value;
   // console.log(dogId);
    if(dogId > 0){
        let dog = myDogs[dogId-1];
        console.log(dog);
        output.textContent = `Vous avez choisie le chien avec l'ID : ${+dogId} , nom : ${dog.name}, age : ${dog.age}, race : ${dog.breed}`;
    }else {
        output.textContent = ""
    }
})
