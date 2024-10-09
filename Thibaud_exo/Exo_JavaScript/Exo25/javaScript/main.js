document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("#mon-form");
    const dogSelect = document.querySelector("#dog-select");
    const selectOutput = document.querySelector("#selectOutput");


    let id = 0;
    const addDogToSelect = (nom, race, age) => {
        const option = document.createElement("option");
        option.value = `${++id}`;
        option.textContent = `${nom} (${race}, ${age} ans)`;
        dogSelect.appendChild(option);
    };


    form.addEventListener("submit", (e) => {
        e.preventDefault();

        const nom = document.querySelector("#dog-name").value;
        const race = document.querySelector("#dog-breed").value;
        const age = document.querySelector("#dog-age").value;

        if (nom !== "null" && race !== "null" && age !== "null") {
            addDogToSelect(nom, race, age);
            form.reset();
        }
    });

    dogSelect.addEventListener("change", () => {
        const selectedOption = dogSelect.options[dogSelect.selectedIndex];
        if (selectedOption.value !== "0") {
            selectOutput.textContent = `Le chien id : ${selectedOption.value} : ${selectedOption.textContent}`;
        } else {
            selectOutput.textContent = "";
        }
    });
});
