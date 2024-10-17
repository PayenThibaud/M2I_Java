import { Component } from '@angular/core';
import { EmojiPipe } from '../../utils/pipes/emoji.pipe';
import { Book } from '../../utils/types/book.type';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-library',
  standalone: true,
  imports: [EmojiPipe, FormsModule],
  templateUrl: './library.component.html',
  styleUrl: './library.component.css'
})
export class LibraryComponent {
  books: Book[] = [
    {id:0, title: 'Livre 1', author: 'Autheur 1', isRead: true},
    {id:1, title: 'Livre 2', author: 'Autheur 2', isRead: false},
    {id:2, title: 'Livre 3', author: 'Autheur 1', isRead: true},
    {id:3, title: 'Livre 4', author: 'Autheur 1', isRead: false},
    {id:4, title: 'Livre 5', author: 'Autheur 3', isRead: true}
  ]

  toggleIsRead(book : Book) : void {
    book.isRead = !book.isRead
  }

  newBook: Pick<Book, 'title' | 'author' > = {
    title: '',
    author: ''
  }

  isSubmitted: boolean = false

  get titleHasError() {
    return !this.newBook.title && this.isSubmitted
  }

  get authorHasError() {
    return !this.newBook.author && this.isSubmitted
  }

  submitNewBook(): void {
    this.isSubmitted = true

    if(!this.authorHasError && !this.titleHasError) {
      const book: Book = {
        id: this.books.length,
        isRead: false,
        ...this.newBook
      /*
        ...this.newBook -> permet de copier les attributs de newBook équivalent à :
        title: this.newBook.title,
        author: this.newBook.author
      */
      }
  
      this.books.push(book)
      this.newBook.title = ''
      this.newBook.author = ''
    }
  }
}
