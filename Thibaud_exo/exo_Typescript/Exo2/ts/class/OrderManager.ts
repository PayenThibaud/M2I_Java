import { IOrder } from "../interface/IOrder";
import { Status } from "../enums/Status";

export class OrderManager {
    private orders: IOrder[] = [];

    public addOrder(order: IOrder): void {
        this.orders.push(order);
    }

    public getOrderById(id: number): IOrder | undefined {
        return this.orders.find(order => order.id === id);
    }

    public updateOrderStatus(id: number, status: Status): boolean {
        const order = this.getOrderById(id);
        if (order) {
            order.status = status;
            return true;
        }
        return false;
    }

    public listOrdersByStatus(status: Status): IOrder[] {
        return this.orders.filter(order => order.status === status);
    }

    public removeOrder(id: number): boolean {
        const orderIndex = this.orders.findIndex(order => order.id === id);
        if (orderIndex !== -1) {
            this.orders.splice(orderIndex, 1);
            return true;
        }
        return false;
    }
}
