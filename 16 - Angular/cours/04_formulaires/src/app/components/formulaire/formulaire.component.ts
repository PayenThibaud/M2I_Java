import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

type User = {
  name: string
  email: string
  password: string
}

@Component({
  selector: 'app-formulaire',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './formulaire.component.html',
  styleUrl: './formulaire.component.css'
})
export class FormulaireComponent {
  message: string = ""
  message2: string = ""
  isSubmitted : boolean = false

  user : User = {
    name: '',
    email: '',
    password: ''
  }

  submitUser() : void {
    this.isSubmitted = true
    if (!this.passwordHasError){
      console.log(this.user);
    }
  }

  updateMessage(event: Event) : void {
    const input = event.target as HTMLInputElement
    this.message = input.value
  }

  get passwordHasError() {
    return this.isSubmitted && this.user.password.length < 6
  }
}
