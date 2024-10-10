const apiUrl = "https://pokeapi.co/api/v2/";
const output = document.getElementById("output");
const output2 = document.getElementById("output2");

let currentPokemonId = null;

const displayResult = (data) => {
    output.textContent = JSON.stringify(data, null, 2);
};

const displayResult2 = (data) => {
    const { name, id, height, weight, types, abilities } = data;

    const typesList = types.map(typeInfo => typeInfo.type.name).join(", ");
    const abilitiesList = abilities.map(abilityInfo => abilityInfo.ability.name).join(", ");

    const result = `
        <p>${name}: et id: ${id}</p>
        <p>Taille : ${height / 10} m</p>
        <p>Poids : ${weight / 10} kg</p>
        <p>Types : ${typesList}</p>
        <p>Capacités : ${abilitiesList}</p>
    `;

    output2.innerHTML = result;

    currentPokemonId = id;
};

const getPokemonByName = async () => {
    const name = prompt("Entrez le nom du pokemon à récupérer:", "pikachu");

    if (name) {
        try {
            const response = await fetch(`${apiUrl}pokemon/${name.toLowerCase()}`);
            const data = await response.json();
            displayResult(data);
            displayResult2(data);
        } catch (error) {
            displayResult({ error: `Erreur lors de la récupération de ${name}` });
        }
    }
};

const getPokemonById = async (id) => {
    try {
        const response = await fetch(`${apiUrl}pokemon/${id}`);
        const data = await response.json();
        displayResult(data);
        displayResult2(data);
    } catch (error) {
        displayResult({ error: `Erreur lors de la récupération de ${id}` });
    }
};

const promptPokemonById = async () => {
    const id = prompt("Entrez le numéro de pokédex national du pokemon:", "25");

    if (id) {
        getPokemonById(parseInt(id));
    }
};

const getPreviousPokemon = () => {
    if (currentPokemonId > 1) {
        getPokemonById(currentPokemonId - 1);
    } else {
        alert("Vous êtes déjà au premier Pokémon !");
    }
};

const getNextPokemon = () => {
    if (currentPokemonId < 1010) {
        getPokemonById(currentPokemonId + 1);
    } else {
        alert("Vous êtes déjà au dernier Pokémon !");
    }
};

document.getElementById("getByNameBtn").addEventListener("click", getPokemonByName);
document.getElementById("getByIdBtn").addEventListener("click", promptPokemonById);
document.getElementById("prevBtn").addEventListener("click", getPreviousPokemon);
document.getElementById("nextBtn").addEventListener("click", getNextPokemon);
