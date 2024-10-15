import { Component } from '@angular/core';

@Component({
  selector: 'app-counter',
  standalone: true,
  imports: [],
  templateUrl: './counter.component.html',
  styleUrl: './counter.component.css'
})
export class CounterComponent {
  counter: number = 0

  increment() : void {
    this.counter++;
  }

  decrement(): void {
    this.counter--
  }

  get color(): string {
    return this.counter % 2 ? 'red': 'green'
  }
}
