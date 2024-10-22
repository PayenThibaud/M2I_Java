import { Component, Input } from '@angular/core';
import { CartService } from '../../utils/services/cart.service';
import { Merch } from '../../utils/types/merch.type';

@Component({
  selector: 'app-merch-card',
  standalone: true,
  imports: [],
  templateUrl: './merch-card.component.html',
  styleUrl: './merch-card.component.css',
})
export class MerchCardComponent {
  @Input() merch!: Merch;

  constructor(private cartService: CartService) {}

  addToCart() {
    this.cartService.add(this.merch);
  }
}
