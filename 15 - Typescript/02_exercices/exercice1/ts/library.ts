// Partie 3 : la classe

import { Book } from "./interface.js";

export class Library {
    private books: Book[] = []

    addBook(book: Book) : void {
        this.books.push(book)
    }

    removeBook(title: string) : void {
        this.books = this.books.filter(book => book.title !== title)
    }

    findBookByTitle(title: string) : Book | undefined {
        return this.books.find(book => book.title === title)
    }

    listAvailableBooks() : Book[] {
        return this.books.filter(book => book.isAvaible)
    }

    getBooksByAuthor(authorName: string): Book[] {
        return this.books.filter(book => book.author.name === authorName)
    }
}