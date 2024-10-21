import { Injectable } from '@angular/core';
import { Cart, CartItem } from '../types/cart.type';
import { Merch } from '../types/merch.type';
import { MerchService } from './merch.service';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  cart: Cart = [];

  constructor(private merchService: MerchService) {
    const cart = localStorage.getItem('cart');
    if (cart) {
      this.cart = JSON.parse(cart);
    }
  }

  saveCart() {
    localStorage.setItem('cart', JSON.stringify(this.cart));
  }

  getTotal() {
    return this.cart.reduce((acc, item) => acc + item.price * item.quantity, 0);
  }

  add(article: Merch) {
    const existing = this.cart.find((a) => a.id === article.id);
    if (existing) {
      existing.quantity += 1;
      existing.total = existing.quantity * existing.price;
    } else {
      let cartItem: CartItem = {
        ...article,
        quantity: 1,
        total: article.price,
      };

      this.cart.push(cartItem);
    }
    this.saveCart();
    this.merchService.changeStock(article, -1);
  }

  remove(article: Merch) {
    this.cart = this.cart.filter((a) => a.id !== article.id);
    this.merchService.changeStock(article, 1);
    this.saveCart();
  }
}
