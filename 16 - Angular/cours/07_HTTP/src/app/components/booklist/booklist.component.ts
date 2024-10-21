import { Component, OnInit } from '@angular/core';
import { Book } from '../../types/book.model';
import { BookService } from '../../services/book.service';

@Component({
  selector: 'app-booklist',
  standalone: true,
  imports: [],
  templateUrl: './booklist.component.html',
  styleUrl: './booklist.component.css'
})
export class BooklistComponent implements OnInit {
  books: Book[] = []

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    // L'observable émet un tableau de livres
    this.bookService.getBooks().subscribe((data: Book[]) => {
      // Mise à jour du tableau avec les données reçues.
      this.books = data
    })
  }

  addBook(): void {
    this.bookService.addBook({id: this.books.length + 1 ,title: "Un titre", author: "Un auteur"})
    .subscribe((data: Book) => {
      this.books.push(data)
    })
  }

  deleteBook(id: number) : void {
    this.bookService.deleteBook(id).subscribe(() => {
      this.books = this.books.filter((book) => book.id !== id )
    })
  }
}
