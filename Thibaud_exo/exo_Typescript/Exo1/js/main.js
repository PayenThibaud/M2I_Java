import { Library } from './class/library';
import { createBook } from './service/bookService';
const author1 = {
    id: 1,
    nom: "Toto",
    dateNaissance: 1900,
    genres: ["fiction", "fantasy"]
};
const author2 = {
    id: 2,
    nom: "Tata",
    dateNaissance: 2000,
    genres: ["fiction", "aventure"]
};
const author3 = {
    id: 3,
    nom: "Titi",
    dateNaissance: 2100,
    genres: ["fantasy", "aventure"]
};
const book1 = createBook("Coucou", author1, 96, true);
const book2 = createBook("LeLivre", author2, 328, true);
const book3 = createBook("HelloWorld", author3, 635, false);
const library = new Library();
library.addBook(book1);
library.addBook(book2);
library.addBook(book3);
console.log("Livre de la biblio");
console.log(library);
console.log("Livre dispo de la biblio");
console.log(library.listAvailableBooks());
console.log("retrait d un livre de la biblio");
library.removeBook(3);
console.log(library);
console.log("ajout de livre de la biblio");
library.addBook(book3);
console.log(library);
console.log("chercher un livre par le titre Coucou dans la biblio");
console.log(library.findBookByTitre("Coucou"));
console.log("chercher un livre par le nom de l auteur Toto dans la biblio");
console.log(library.getBooksByAuthor("Toto"));
