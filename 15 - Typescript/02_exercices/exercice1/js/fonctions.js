export function createBook(title, author, pages) {
    return {
        title: title,
        author: author,
        pages: pages,
        isAvaible: true
    };
}
export function toggleAvailability(book) {
    book.isAvaible = !book.isAvaible;
}
