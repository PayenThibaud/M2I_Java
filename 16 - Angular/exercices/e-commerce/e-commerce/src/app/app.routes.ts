import { Routes } from '@angular/router';
import { AdminComponent } from './pages/admin/admin.component';
import { CartComponent } from './pages/cart/cart.component';
import { HomeComponent } from './pages/home/home.component';

export const routes: Routes = [
  { path: '', component: HomeComponent, title: "Home" },
  { path: 'admin', component: AdminComponent, title: "Admin" },
  { path: 'cart', component: CartComponent, title: "Cart" },
];
