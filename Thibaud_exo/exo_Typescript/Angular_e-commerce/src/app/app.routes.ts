import { Routes } from '@angular/router';
import {AccueilComponent} from './page/accueil/accueil.component';
import {ClientComponent} from './page/client/client.component';
import {AdminComponent} from './page/admin/admin.component';

export const routes: Routes = [
  {path: "", component: AccueilComponent},
  {path: "client", component: ClientComponent},
  {path: "admin", component: AdminComponent},
];
