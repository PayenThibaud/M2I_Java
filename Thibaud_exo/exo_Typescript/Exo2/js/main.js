import { calculateTotal, createOrder } from "./service/OrderService.js";
import { OrderManager } from "./class/OrderManager.js";
import { Status } from "./enums/Status.js";
const client1 = {
    id: 1,
    nom: "Titi",
    email: "Titi@gmail.com"
};
const client2 = {
    id: 2,
    nom: "Tata",
    email: "Tata@gmail.com"
};
const produit1 = {
    id: 1,
    nom: "Console",
    prix: 300,
    stock: 10
};
const produit2 = {
    id: 2,
    nom: "Manette",
    prix: 50,
    stock: 20
};
const article_dans_commande1 = {
    product: produit1,
    quantite: 1
};
const article_dans_commande2 = {
    product: produit2,
    quantite: 4
};
const article_dans_commande3 = {
    product: produit1,
    quantite: 1
};
const article_dans_commande4 = {
    product: produit2,
    quantite: 2
};
const table_de_commande1 = [
    article_dans_commande1,
    article_dans_commande2
];
const table_de_commande2 = [
    article_dans_commande3,
    article_dans_commande4
];
const order1 = createOrder(client1, table_de_commande1);
const order2 = createOrder(client2, table_de_commande2);
const orderManager = new OrderManager();
console.log("Ajout order 1 dans orderManager");
orderManager.addOrder(order1);
console.log(orderManager);
console.log("Ajout order 2 dans orderManager");
orderManager.addOrder(order2);
console.log(orderManager);
console.log("Prix des commandes");
const prix_order1 = calculateTotal(orderManager.getOrderById(1));
console.log(prix_order1);
const prix_order2 = calculateTotal(orderManager.getOrderById(2));
console.log(prix_order2);
console.log("Changement de status");
orderManager.updateOrderStatus(2, Status.Livree);
const list_attente = orderManager.listOrdersByStatus(Status.EnAttente);
const list_livree = orderManager.listOrdersByStatus(Status.Livree);
console.log("Commande en attente");
console.log(list_attente);
console.log("Commande livree");
console.log(list_livree);
console.log("Supprimer une commande");
orderManager.removeOrder(2);
console.log(orderManager);
