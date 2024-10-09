import { Chien } from './class/chien.js';

let chiens = [];

function addChien(nom, race, age) {
    const chien = new Chien(nom, race, age);
    chiens.push(chien);
    select();
}

function select() {
    const select = document.getElementById("dog-select");
    select.innerHTML = `<option value="0">Sélectionnez un chien</option>`;

    chiens.forEach(chien => {
        const option = document.createElement("option");
        option.value = chien.id;
        option.textContent = `Chien ${chien.id}: ${chien.nom}`;
        select.appendChild(option);
    });
}

function displayChien(id) {
    const chien = chiens.find(chien => chien.id === parseInt(id));
    const output = document.getElementById("selectOutput");
    output.innerHTML = `<div>${chien.display()}</div>`;
}

document.getElementById("btn-submit").addEventListener("click", (e) => {
    e.preventDefault();
    const nom = document.getElementById("dog-name").value;
    const race = document.getElementById("dog-breed").value;
    const age = document.getElementById("dog-age").value;

    if (nom && race && age) {
        addChien(nom, race, age);
        document.getElementById("mon-form").reset();
    }
});

document.getElementById("dog-select").addEventListener("change", (e) => {
    displayChien(e.target.value);
});
