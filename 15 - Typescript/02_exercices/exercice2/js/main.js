// Partie 1
// Partie 2
function createOrder(customer, items) {
    return {
        id: Math.random(),
        customer: customer,
        items: items,
        status: 'en attente'
    };
}
function calculTotal(order) {
    return order.items.reduce((total, item) => total + item.product.price * item.quantity, 0);
}
// Partie 3
class OrderManager {
    constructor() {
        this.orders = [];
    }
    addOrder(order) {
        this.orders.push(order);
    }
    getOrderById(id) {
        return this.orders.find(order => order.id === id);
    }
    updateOrderStatus(id, status) {
        const order = this.getOrderById(id);
        if (order) {
            order.status = status;
        }
    }
    listOrdersByStatus(status) {
        return this.orders.filter(order => order.status === status);
    }
    removeOrder(id) {
        this.orders = this.orders.filter(order => order.id !== id);
    }
}
const product1 = { id: 1, name: 'pc', price: 500, stock: 2 };
const product2 = { id: 2, name: 'souris', price: 50, stock: 10 };
const customer = {
    id: 1,
    name: "toto",
    email: "toto@email.fr"
};
const orderItem = {
    product: product1,
    quantity: 2
};
const order = createOrder(customer, [orderItem]);
const orderManager = new OrderManager();
orderManager.addOrder(order);
console.log(calculTotal(order));
