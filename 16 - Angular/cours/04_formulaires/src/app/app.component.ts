import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormulaireComponent } from './components/formulaire/formulaire.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormulaireComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = '04_formulaires';
}
