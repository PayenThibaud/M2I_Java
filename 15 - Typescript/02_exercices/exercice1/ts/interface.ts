// Partie 1 : interfaces

export interface Author {
    name: string
    birthYear: number
    genres: string[]
}

export interface Book {
    title: string
    author: Author
    pages: number
    isAvaible: boolean
}