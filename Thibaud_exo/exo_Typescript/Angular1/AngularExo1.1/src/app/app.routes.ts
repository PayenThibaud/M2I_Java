import { Routes } from '@angular/router';
import {SeriesComponent} from './component/series/series.component';
import {CounterComponent} from './component/counter/counter.component';

export const routes: Routes = [
  {path: '', component: SeriesComponent},
  {path: 'counter', component: CounterComponent}
];
