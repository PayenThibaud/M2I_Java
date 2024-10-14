import {ICustomer} from "./ICustomer.js";
import {IOrderItem} from "./IOrderItem.js";
import {Status} from "../enums/Status.js";

export interface IOrder {
    id: number
    client: ICustomer
    tableArticle: IOrderItem[]
    status: Status
}

