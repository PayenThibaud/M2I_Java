import {IAuthor} from "./IAuthor";

export interface IBook {
    id: number
    titre: string
    author: IAuthor
    pages: number
    isAvailable: boolean
}

