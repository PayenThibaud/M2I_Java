import {ICustomer} from "./interface/ICustomer.js";
import {IProduct} from "./interface/IProduct.js";
import {IOrderItem} from "./interface/IOrderItem.js";
import {calculateTotal, createOrder} from "./service/OrderService.js";
import {IOrder} from "./interface/IOrder.js";
import {OrderManager} from "./class/OrderManager.js";
import {Status} from "./enums/Status.js";

const client1: ICustomer = {
    id: 1,
    nom: "Titi",
    email: "Titi@gmail.com"
}

const client2: ICustomer = {
    id: 2,
    nom: "Tata",
    email: "Tata@gmail.com"
}

const produit1: IProduct = {
    id: 1,
    nom: "Console",
    prix: 300,
    stock: 10
}

const produit2: IProduct = {
    id: 2,
    nom: "Manette",
    prix: 50,
    stock: 20
}

const article_dans_commande1: IOrderItem = {
    product: produit1,
    quantite: 1
}

const article_dans_commande2: IOrderItem = {
    product: produit2,
    quantite: 4
}

const article_dans_commande3: IOrderItem = {
    product: produit1,
    quantite: 1
}

const article_dans_commande4: IOrderItem = {
    product: produit2,
    quantite: 2
}

const table_de_commande1: IOrderItem[] = [
    article_dans_commande1,
    article_dans_commande2

];


const table_de_commande2: IOrderItem[] = [
    article_dans_commande3,
    article_dans_commande4
];

const order1: IOrder = createOrder(client1, table_de_commande1);
const order2: IOrder = createOrder(client2, table_de_commande2);

const orderManager: OrderManager = new OrderManager();

console.log("Ajout order 1 dans orderManager");
orderManager.addOrder(order1);
console.log(orderManager);

console.log("Ajout order 2 dans orderManager");
orderManager.addOrder(order2);
console.log(orderManager);

console.log("Prix des commandes");
const prix_order1: number = calculateTotal(orderManager.getOrderById(1));
console.log(prix_order1);
const prix_order2: number = calculateTotal(orderManager.getOrderById(2));
console.log(prix_order2);

console.log("Changement de status")
orderManager.updateOrderStatus(2, Status.Livree);
const list_attente: IOrder[] = orderManager.listOrdersByStatus(Status.EnAttente);
const list_livree: IOrder[] = orderManager.listOrdersByStatus(Status.Livree);
console.log("Commande en attente")
console.log(list_attente)
console.log("Commande livree")
console.log(list_livree)

console.log("Supprimer une commande")
orderManager.removeOrder(2);
console.log(orderManager);