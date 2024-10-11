// Interfaces
let user = {
    id: 1,
    name: "toto",
    email: "toto@email.fr",
    isActive: true
};
let user2 = {
    id: 1,
    name: "Toto",
    isActive: false
};
// user2.id = 2; // Erreur : id est en lecture seule
console.log(user2.id);
user.name = "tata";
let userOne = null;
let userTwo = {
    id: 1,
    name: "Toto",
    isActive: true
};
let userStatus = "active";
let admin = {
    id: 1,
    name: "John",
    isActive: true,
    adminLevel: 3,
    mdp: "123"
};
