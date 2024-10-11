import {ICustomer} from "../interface/ICustomer";
import {IOrderItem} from "../interface/IOrderItem";
import {IOrder} from "../interface/IOrder";
import {Status} from "../enums/Status";


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