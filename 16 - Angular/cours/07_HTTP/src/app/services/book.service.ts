import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../types/book.model';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private apiUrl = 'http://localhost:3000/books'

  constructor(private http: HttpClient) { }

  getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.apiUrl)
  }

  getBook(id: number): Observable<Book> {
    return this.http.get<Book>(`${this.apiUrl}/${id}`) // http://localhost:3000/books/1
  }

  addBook(book: Book): Observable<Book> {
    return this.http.post<Book>(this.apiUrl, book)
  }

  deleteBook(id: number): Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/${id}`)
  }
}
