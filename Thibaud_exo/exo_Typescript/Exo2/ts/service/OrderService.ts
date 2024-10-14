import {ICustomer} from "../interface/ICustomer.js";
import {IOrderItem} from "../interface/IOrderItem.js";
import {IOrder} from "../interface/IOrder.js";
import {Status} from "../enums/Status.js";


let id: number = 0;

export function createOrder(client: ICustomer, items: IOrderItem[]): IOrder {
    return {
        id: ++id,
        client: client,
        tableArticle: items,
        status: Status.EnAttente
    };
}

export function calculateTotal(order: IOrder): number {
    let prixTotal: number = 0;

    for (const item of order.tableArticle) {
         prixTotal += item.product.prix * item.quantite;
    }

    return prixTotal;
}