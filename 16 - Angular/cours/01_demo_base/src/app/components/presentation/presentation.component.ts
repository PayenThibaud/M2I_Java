import { Component } from '@angular/core';

@Component({
  selector: 'app-presentation',
  standalone: true,
  imports: [],
  templateUrl: './presentation.component.html',
  styleUrl: './presentation.component.css'
})
export class PresentationComponent {
  name: string = "toto"
  isLogged: boolean = true
  m2i: string = "https://campusnumerique.auvergnerhonealpes.fr/app/uploads/2021/10/logo_m2iformation.jpg"
  color: object = {
    color: "red",
    backgroundColor: "blue"
  }
  maClassA: string = 'blue'
  maClassB: string = 'red'

  toggleLogged() : void {
    this.isLogged = !this.isLogged
  }
}
