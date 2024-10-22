import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, map, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChuckService {
  private api_url: string = "https://api.chucknorris.io/jokes/random"

  constructor(private http: HttpClient) { }

  getRandomFact() : Observable<string>{
    return this.http.get<{value: string}>(this.api_url).pipe(
      map(response => response.value),
      catchError(error => {
        alert(error.message)
        return of('')
      })
    )
  }
}
