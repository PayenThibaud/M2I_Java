import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../types/user.type';
import { catchError, Observable, of, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  apiUrl: string = 'http://localhost:3000'

  constructor(private http: HttpClient) { }

  register(user: User): Observable<User> {
    return this.http.post<User>(this.apiUrl + '/register', user).pipe(
      catchError((error) => {
        alert(error.message)
        return of()
      })
    )
  }

  login(credential: Pick<User, "email" | "password">): Observable<{accessToken: string}>{
    return this.http.post<{accessToken: string}>(this.apiUrl + '/login', credential).pipe(
      tap((res) => localStorage.setItem('token', res.accessToken)),
      tap(() => alert('Bienvenue !')),
      catchError((error) => {
        alert(error.message)
        return of()
      })
    )
  }

  getToken(): string | null {
    return localStorage.getItem('token')
  }
}
