import { Component } from '@angular/core';
import { EnfantComponent } from '../enfant/enfant.component';

interface User {
  nom: string;
  age: number
}


@Component({
  selector: 'app-parent',
  standalone: true,
  imports: [EnfantComponent],
  templateUrl: './parent.component.html',
  styleUrl: './parent.component.css'
})
export class ParentComponent {
  parentMessage: string = "Hello depuis le composant parent !"

  // user: User = {
  //   nom: "toto",
  //   age: 30
  // }

  listUser: User[] = [
    {
      nom: "toto",
      age: 30
    },
    {
      nom: "tata",
      age: 35
    },
    {
      nom: "titi",
      age: 50
    }
  ]

  receiveData: string = ""

  handleData(data: string) {
    this.receiveData = data
  }
}
