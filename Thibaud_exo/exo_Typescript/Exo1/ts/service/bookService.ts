import { IAuthor } from "../interface/IAuthor";
import { IBook } from "../interface/IBook";

let id: number = 0;

export function createBook(titre: string, author: IAuthor, pages: number, available : boolean): IBook {
    return {
        id: ++id,
        titre: titre,
        author: author,
        pages: pages,
        isAvailable: available
    };
}

export function toggleAvailability(book: IBook): IBook {
    book.isAvailable = !book.isAvailable;
    return book;
}
