import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { BlocksComponent } from './pages/blocks/blocks.component';

export const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'blocks', component: BlocksComponent}
];
