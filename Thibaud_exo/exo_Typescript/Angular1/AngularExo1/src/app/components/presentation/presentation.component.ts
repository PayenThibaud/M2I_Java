import { Component } from '@angular/core';

@Component({
  selector: 'app-presentation',
  standalone: true,
  imports: [],
  templateUrl: './presentation.component.html',
  styleUrl: './presentation.component.css'
})
export class PresentationComponent {
  name: string = "Titi"
  isLogged: boolean = false;
  image: string = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTRivw1cFjGfFTibTEeNoi2N5iF6h2dk8dRR0U3nm8twZe6-W31w6sGxtsFIPm2aCCxIA&usqp=CAU"
  color: object = {
    color: "green",
    backgroundColor: "black"
  }
  maClasseA:string = "blue"
  maClasseB:string = "red"

  toggleLogged() : void {
    this.isLogged = !this.isLogged;
  }

}
