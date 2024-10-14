import { Status } from "../enums/Status.js";
let id = 0;
export function createOrder(client, items) {
    return {
        id: ++id,
        client: client,
        tableArticle: items,
        status: Status.EnAttente
    };
}
export function calculateTotal(order) {
    let prixTotal = 0;
    for (const item of order.tableArticle) {
        prixTotal += item.product.prix * item.quantite;
    }
    return prixTotal;
}
