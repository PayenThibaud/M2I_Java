import { Component } from '@angular/core';

@Component({
  selector: 'app-series',
  standalone: true,
  imports: [],
  templateUrl: './series.component.html',
  styleUrl: './series.component.css'
})
export class SeriesComponent {
  series: string[] = ["Série 1", "Série 2", "Série 3"]

  removeSerie(index : number) : void {
    this.series.splice(index, 1)
  }
}
