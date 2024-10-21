import { Component } from '@angular/core';
import { MerchCardComponent } from '../../components/merch-card/merch-card.component';
import { MerchService } from '../../utils/services/merch.service';
import { Merch } from '../../utils/types/merch.type';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MerchCardComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  merchList: Merch[] = [];

  constructor(private merchService: MerchService) {
    this.merchList = merchService.merchList;
  }
}
