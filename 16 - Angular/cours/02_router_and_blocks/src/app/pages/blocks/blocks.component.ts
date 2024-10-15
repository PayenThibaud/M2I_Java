import { Component } from '@angular/core';

type days = 'Lundi' | 'Mardi' | 'Mercredi' | 'Jeudi' | 'Vendredi'

@Component({
  selector: 'app-blocks',
  standalone: true,
  imports: [],
  templateUrl: './blocks.component.html',
  styleUrl: './blocks.component.css'
})
export class BlocksComponent {
  isLogged: boolean = false
  today: days = "Mardi"
  users: string[] = []

  toggleLogged() : void {
    this.isLogged = !this.isLogged
  }
}
