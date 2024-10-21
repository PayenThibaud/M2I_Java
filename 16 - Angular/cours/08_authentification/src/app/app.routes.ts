import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { isLoggedGuard } from './utils/guards/is-logged.guard';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';

export const routes: Routes = [
    {path: "", component: HomeComponent, canActivate: [isLoggedGuard]},
    {path: "login", component: LoginComponent},
    {path: "register", component: RegisterComponent}
];
