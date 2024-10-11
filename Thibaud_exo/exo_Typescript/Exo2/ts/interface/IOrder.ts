import {ICustomer} from "./ICustomer";
import {IOrderItem} from "./IOrderItem";
import {Status} from "../enums/Status";

export interface IOrder {
    id: number
    client: ICustomer
    tableArticle: IOrderItem[]
    status: Status
}

