let id = 0;
export function createBook(titre, author, pages, available) {
    return {
        id: ++id,
        titre: titre,
        author: author,
        pages: pages,
        isAvailable: available
    };
}
export function toggleAvailability(book) {
    book.isAvailable = !book.isAvailable;
    return book;
}
