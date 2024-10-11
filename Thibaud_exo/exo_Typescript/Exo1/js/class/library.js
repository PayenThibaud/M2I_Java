export class Library {
    constructor() {
        this.books = []; // Tableau de livres
    }
    addBook(book) {
        this.books.push(book);
    }
    removeBook(id) {
        this.books = this.books.filter(e => e.id !== id);
    }
    findBookByTitre(titre) {
        return this.books.find(e => e.titre === titre);
    }
    listAvailableBooks() {
        return this.books.filter(e => e.isAvailable);
    }
    getBooksByAuthor(authorNom) {
        return this.books.filter(e => e.author.nom === authorNom);
    }
}
