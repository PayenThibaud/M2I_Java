import { createBook, toggleAvailability } from "./fonctions.js";
import { Author, Book } from "./interface.js";
import { Library } from "./library.js";

// Création des auteurs
const author1: Author = {
    name: "toto",
    birthYear: 2000,
    genres: ["Fantasy", "Drama"]
}
const author2: Author = {
    name: "tata",
    birthYear: 1990,
    genres: ["Aventure"]
}

// Création des livres

const book1 = createBook("titre1", author1, 200)
const book2 = createBook("titre2", author2, 150)
const book3 = createBook("titre3", author1, 500)

// Création de la librairie

const library = new Library()
library.addBook(book1)
library.addBook(book2)
library.addBook(book3)

console.log(library.listAvailableBooks());

toggleAvailability(book3)
console.log(library.listAvailableBooks());

console.log(library.getBooksByAuthor("tata"));

library.removeBook("titre1")
console.log(library.listAvailableBooks());

console.log(library.findBookByTitle("titre3"));