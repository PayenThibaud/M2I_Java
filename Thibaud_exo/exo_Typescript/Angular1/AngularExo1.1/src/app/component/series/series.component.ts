import { Component } from '@angular/core';

@Component({
  selector: 'app-series',
  standalone: true,
  imports: [],
  templateUrl: './series.component.html',
  styleUrl: './series.component.css'
})
export class SeriesComponent {
  listSeries: string[] = [
    'Breaking Bad',
    'Stranger Things',
    'Game of Thrones',
    'The Witcher',
    'Money Heist'
  ];

  delete(i: number): void {
    if (i >= 0 && i < this.listSeries.length) {
      this.listSeries.splice(i, 1);
    }
  }
}
