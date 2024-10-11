// Partie 2 : fonctions
import { Author, Book } from "./interface.js";

export function createBook(title: string, author: Author, pages: number) : Book {
    return {
        title: title,
        author: author,
        pages: pages,
        isAvaible: true
    }
}

export function toggleAvailability(book: Book) : void {
    book.isAvaible = !book.isAvaible
}