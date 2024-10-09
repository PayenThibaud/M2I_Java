const apiUrl = "https://jsonplaceholder.typicode.com/posts";
const output = document.getElementById("output");

// Fonction pour afficher les résultats dans le bloc <pre>
const displayResult = (data) => {
    output.textContent = JSON.stringify(data, null, 2);
};

// --------------------- CREATE ---------------------
// Création d'un nouveau post
const createPost = async () => {
    const newPost = {
        title: "Mon nouveau post",
        body: "Ceci est le contenu de mon nouveau post.",
        userId: 1,
    };

    try {
        const response = await fetch(apiUrl, {
            method: "POST", // Méthode HTTP POST pour créer un nouveau post
            headers: {
                "Content-Type": "application/json",
                // 'Authorization': 'Bearer votreToken'
            },
            body: JSON.stringify(newPost), // Corps de la requête avec le nouveau post en format JSON
        });
        console.log("Ma reponse :")
        console.log(response)
        console.log("Status de ma reponse :")
        console.log(response.status)
        const data = await response.json(); // Conversion de la réponse en format JSON
        console.log("Data de a reponse :")
        console.log(data)
        displayResult(data); // Affichage du nouveau post créé
    } catch (error) {
        displayResult({ error: "Erreur lors de la création du post" }); // Gestion des erreurs
    }
};

// --------------------- READ ---------------------
// Récupération de tous les posts
const getPosts = async () => {
    try {
        const response = await fetch(apiUrl); // Requête GET pour récupérer tous les posts
        const data = await response.json();  // Conversion de la réponse en format JSON
        displayResult(data); // Affichage de tous les posts
        console.log(data[39])
    } catch (error) {
        displayResult({ error: "Erreur lors de la récupération des posts" }); // Gestion des erreurs
    }
};

// Fonction pour récupérer un post spécifique par ID
const getPostById = async () => {
    const id = prompt("Entrez l'ID du post à récupérer:", "1");

    if (id) {
        try {
            const response = await fetch(`${apiUrl}/${id}`); // Requête GET avec l'ID du post à récupérer
            const data = await response.json(); // Conversion de la réponse en format JSON
            displayResult(data); // Affichage du post spécifié
           
        } catch (error) {
            displayResult({ error: `Erreur lors de la récupération du post ${id}` }); // Gestion des erreurs
        }
    }
};

// --------------------- UPDATE ---------------------
// Mise à jour d'un post existant
const updatePost = async () => {
    const id = prompt("Entrez l'ID du post à mettre à jour:", "1");

    if (id) {
        const updatedPost = {
            title: "Titre mis à jour",
            body: "Contenu mis à jour de mon post.",
            userId: 42,
        };

        try {
            const response = await fetch(`${apiUrl}/${id}`, {
                method: "PUT", // Méthode HTTP PUT pour mettre à jour un post
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(updatedPost), // Corps de la requête avec les nouvelles données du post
            });

            const data = await response.json(); // Conversion de la réponse en format JSON
            displayResult(data); // Affichage du post mis à jour
        } catch (error) {
            displayResult({ error: `Erreur lors de la mise à jour du post ${id}` }); // Gestion des erreurs
        }
    }
};

// --------------------- DELETE ---------------------
// Suppression d'un post par ID
const deletePost = async () => {
    const id = prompt("Entrez l'ID du post à supprimer:", "1");

    if (id) {
        try {
            await fetch(`${apiUrl}/${id}`, {
                method: "DELETE", // Méthode HTTP DELETE pour supprimer un post
            });

            displayResult({ message: `Post ${id} supprimé.` }); // Confirmation de la suppression
        } catch (error) {
            displayResult({ error: `Erreur lors de la suppression du post ${id}` }); // Gestion des erreurs
        }
    }
};

// Attachement des fonctions aux boutons
document.getElementById("createBtn").addEventListener("click", createPost);
document.getElementById("getAllBtn").addEventListener("click", getPosts);
document.getElementById("getByIdBtn").addEventListener("click", getPostById);
document.getElementById("updateBtn").addEventListener("click", updatePost);
document.getElementById("deleteBtn").addEventListener("click", deletePost);