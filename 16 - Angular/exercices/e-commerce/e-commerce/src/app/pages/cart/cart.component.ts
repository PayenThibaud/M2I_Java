import { Component } from '@angular/core';
import { CartService } from '../../utils/services/cart.service';
import { MerchService } from '../../utils/services/merch.service';
import { Cart } from '../../utils/types/cart.type';
import { Merch } from '../../utils/types/merch.type';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css',
})
export class CartComponent {
  cart: Cart = [];
  total: number = 0;

  constructor(
    private cartService: CartService,
    private merchService: MerchService
  ) {
    this.cart = cartService.cart;
    this.total = cartService.getTotal();
  }

  delete(id: number) {
    const merch = this.merchService.merchList.find((m) => m.id === id) as Merch;
    this.cartService.remove(merch);

    // Mettre à jour le tableau cart et le total après la suppression
    this.cart = this.cartService.cart; // Récupérer le panier mis à jour
    this.total = this.cartService.getTotal(); // Mettre à jour le total
  }
}
