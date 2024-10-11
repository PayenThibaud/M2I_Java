import { IBook } from "../interface/IBook"; // Assurez-vous que le chemin est correct

export class Library {
    private books: IBook[] = []; // Tableau de livres

    public addBook(book: IBook): void {
        this.books.push(book);
    }

    public removeBook(id: number): void {
        this.books = this.books.filter(e => e.id !== id);
    }

    public findBookByTitre(titre: string): IBook | undefined {
        return this.books.find(e => e.titre === titre);
    }

    public listAvailableBooks(): IBook[] {
        return this.books.filter(e => e.isAvailable);
    }

    public getBooksByAuthor(authorNom: string): IBook[] {
        return this.books.filter(e => e.author.nom === authorNom);
    }
}
