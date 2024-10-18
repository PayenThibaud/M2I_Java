import { Component, EventEmitter, Input, Output } from '@angular/core';

interface User {
  nom: string;
  age: number
}

@Component({
  selector: 'app-enfant',
  standalone: true,
  imports: [],
  templateUrl: './enfant.component.html',
  styleUrl: './enfant.component.css'
})
export class EnfantComponent {
  @Input() message!: string 
  @Input() user!: User;

  @Output() dataEmitted = new EventEmitter<string>()

  sendData() {
    this.dataEmitted.emit('Hello depuis le composant enfant !')
  }
}
