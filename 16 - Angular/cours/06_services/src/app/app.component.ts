import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormationsComponent } from './pages/formations/formations.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormationsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = '06_services';
}
