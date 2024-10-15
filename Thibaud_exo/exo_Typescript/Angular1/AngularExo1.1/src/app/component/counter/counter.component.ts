import { Component } from '@angular/core';

@Component({
  selector: 'app-counter',
  standalone: true,
  imports: [],
  templateUrl: './counter.component.html',
  styleUrl: './counter.component.css'
})
export class CounterComponent {
  chiffre: number = 0;
  isPair: boolean = true;

  chiffrePlus1() : void {
    this.chiffre++;
    this.verifPairChiffre();
  }

  chiffreMoins1() : void {
    this.chiffre--;
    this.verifPairChiffre();
  }

  verifPairChiffre() : void {
    this.isPair = this.chiffre % 2 === 0;
  }

  vert: string = "green";
  rouge: string = "red";

}
