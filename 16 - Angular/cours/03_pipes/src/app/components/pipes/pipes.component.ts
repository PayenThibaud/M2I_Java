import { DatePipe, DecimalPipe, LowerCasePipe, UpperCasePipe } from '@angular/common';
import { Component } from '@angular/core';
import { UppertablePipe } from '../../utils/pipes/uppertable.pipe';

@Component({
  selector: 'app-pipes',
  standalone: true,
  imports: [UpperCasePipe, LowerCasePipe, DatePipe, DecimalPipe, UppertablePipe],
  templateUrl: './pipes.component.html',
  styleUrl: './pipes.component.css'
})
export class PipesComponent {
  message: string = "hello world"
  messageMaj: string = "HELLO WORLD EN MAJUSCULE"
  today: Date = new Date()
  pi: number = Math.PI
  tab: string[] = ["toto", "tata", "titi"]
}
