import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

export const isLoggedGuard: CanActivateFn = (route, state) => {
  const router = inject(Router)
  const authService = inject(AuthService)
  const token = authService.getToken()
  if(!token) {
    alert("Vous n'êtes pas autorisé à accéder à cette route")
    router.navigate(['/login'])
    return false
  } 
  return true
};
