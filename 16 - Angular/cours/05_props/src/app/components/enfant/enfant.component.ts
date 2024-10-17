import { Component, Input } from '@angular/core';

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
}
