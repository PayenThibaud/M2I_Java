import { Component } from '@angular/core';

@Component({
  selector: 'app-blocks',
  standalone: true,
  imports: [],
  templateUrl: './blocks.component.html',
  styleUrl: './blocks.component.css'
})
export class BlocksComponent {
  isLogged: boolean = false

  toggleLogged() : void {
    this.isLogged = !this.isLogged
  }
}
