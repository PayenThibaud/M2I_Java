const BASE_POKEAPI_URL = "https://pokeapi.co/api/v2/"; // On met en commun l'URL de base de l'api visée pour que nos fonctions puissent l'exploiter
const NB_OF_POKEMON_AVAILABLE = 1_017; // On stocke en dur la quantité de pokémon disponible de sorte à n'avoir qu'une constante à changer en cas d'évolution des Pokémon à l'avenir
let currentPokemon; // On cherche à stocker le pokémon actuel de sorte à pouvoir baser notre interface dessus


const capitilize = (text) =>
  text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();


const fetchPokemonByNameOrId = async (nameOrId) => {
  currentPokemon = null;
  const response = await fetch(BASE_POKEAPI_URL + `pokemon/${nameOrId}`);
  if (response.status !== 200) throw new Error("Cannot GET that Pokemon!"); // Si la requête ne retourne pas un code status correspondant à 'OK, ça passe!' on lève une erreur
  const data = await response.json();
  if (!data) throw new Error("No data!"); // Si la réponse ne contient pas de données dans son corps, on lève une erreur
  currentPokemon = {
    name: capitilize(data.name),
    height: data.height,
    weight: data.weight,
    id: data.id,
    sprite: data.sprites["front_default"],
    abilities: data.abilities.map((x) => capitilize(x.ability.name)),
    types: data.types.map((x) => capitilize(x.type.name)),
  };
};


const resetPokemonDisplay = () => {
  document.getElementById("pokemon-picture").src = "./assets/img/pokeball.png";
  document.getElementById("pokemon-name").textContent = "NAME";
  document.getElementById("pokemon-weight").textContent = "WEIGHT";
  document.getElementById("pokemon-height").textContent = "HEIGHT";
  document.getElementById("pokemon-types").innerHTML = "";

  document.getElementById("pokemon-abilities").innerHTML = "";

  document.getElementById("pokemon-previous").disabled = true;
  document.getElementById("pokemon-next").disabled = true;
};


const updatePokemonDisplay = () => {
  document.getElementById("pokemon-picture").src = currentPokemon.sprite;
  document.getElementById("pokemon-name").textContent = currentPokemon.name;
  document.getElementById("pokemon-weight").textContent =
    currentPokemon.weight + "lbs";
  document.getElementById("pokemon-height").textContent =
    currentPokemon.height + '"';
  document.getElementById("pokemon-types").innerHTML = "";
  for (const t of currentPokemon.types) {
    // Pour chaque élément présent dans le listing, on va créé une balise <li> de sorte à pouvoir la placer dans la balise <ul>
    const newLIElement = document.createElement("li");
    newLIElement.textContent = t;
    document.getElementById("pokemon-types").appendChild(newLIElement);
  }
  document.getElementById("pokemon-abilities").innerHTML = "";
  for (const a of currentPokemon.abilities) {
    // Pour chaque élément présent dans le listing, on va créé une balise <li> de sorte à pouvoir la placer dans la balise <ul>
    const newLIElement = document.createElement("li");
    newLIElement.textContent = a;
    document.getElementById("pokemon-abilities").appendChild(newLIElement);
  }
  document.getElementById("pokemon-previous").disabled = currentPokemon.id <= 1;
  document.getElementById("pokemon-next").disabled =
    currentPokemon.id >= NB_OF_POKEMON_AVAILABLE;
};

document.addEventListener("DOMContentLoaded", () => {
  // Event listener de l'envoi du formulaire (on empêche le fonctionnement par défaut de sorte à éviter les rafraichissement de la page non désirés et perdre ainsi les données)
  document
    .getElementById("pokemon-search")
    .addEventListener("submit", async (e) => {
      e.preventDefault();
      resetPokemonDisplay();
      const searchInput = document.getElementById("search-input").value;
      try {
        await fetchPokemonByNameOrId(searchInput);
        if (currentPokemon) updatePokemonDisplay();
      } catch (e) {
        console.error(e);
      }
    });

  // Event listener du bouton précédent
  document
    .getElementById("pokemon-previous")
    .addEventListener("click", async () => {
      if (currentPokemon.id - 1 >= 1) resetPokemonDisplay();
      try {
        await fetchPokemonByNameOrId(currentPokemon.id - 1);
        if (currentPokemon) updatePokemonDisplay();
      } catch (e) {
        console.error(e);
      }
    });

  // Event listener du bouton suivant
  document
    .getElementById("pokemon-next")
    .addEventListener("click", async () => {
      if (currentPokemon.id - 1 <= NB_OF_POKEMON_AVAILABLE)
        resetPokemonDisplay();
      try {
        await fetchPokemonByNameOrId(currentPokemon.id + 1);
        if (currentPokemon) updatePokemonDisplay();
      } catch (e) {
        console.error(e);
      }
    });
});
