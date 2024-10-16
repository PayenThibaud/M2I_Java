import { Component } from '@angular/core';
import { SortPipe } from '../../utils/pipes/sort.pipe';

type order = 'asc' | 'desc'

@Component({
  selector: 'app-series',
  standalone: true,
  imports: [SortPipe],
  templateUrl: './series.component.html',
  styleUrl: './series.component.css'
})
export class SeriesComponent {
  series: string[] = ["Série 1", "Série 2", "Série 3"]

  removeSerie(index : number) : void {
    // this.series.splice(index, 1)
    this.series = this.series.filter((_, i) => i != index)
  }

  order: order = 'asc'

  setOrder(order : order) : void {
    this.order = order
  }
}
