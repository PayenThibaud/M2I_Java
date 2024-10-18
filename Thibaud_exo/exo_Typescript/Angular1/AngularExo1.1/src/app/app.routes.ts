import { Routes } from '@angular/router';
import {SeriesComponent} from './component/series/series.component';
import {CounterComponent} from './component/counter/counter.component';
import {PipeComponent} from './component/pipe/pipe.component';
import {LibrairieComponent} from './component/librairie/librairie.component';
import {PokemonComponent} from './pokemon/pokemon/pokemon.component';
import {PokemonCardComponent} from './pokemon/pokemon-card/pokemon-card.component';

export const routes: Routes = [
  {path: '', component: SeriesComponent},
  {path: 'counter', component: CounterComponent},
  {path: 'pipe', component: PipeComponent},
  {path: 'librairie', component: LibrairieComponent},
  {path: 'pokemon', component: PokemonComponent},
  {path: 'pokemon-card', component: PokemonCardComponent}
];
