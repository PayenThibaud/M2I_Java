// Interfaces

// Une interface est un contrat qui définit la forme d'un objet, Elle spécifie les 
// propriétés et leurs types.

// Certaines propriétés peuvent être marquées comme opionelles en utilisant le symbole '?'
interface User {
    id: number
    name: string
    email?: string
    isActive: boolean
}

let user: User = {
    id: 1,
    name: "toto",
    email: "toto@email.fr",
    isActive: true
}

// Propriétés en lecture seule ('readonly')
//  Les propriétés peuvent être marquées en readonly,
// ce qui empêche leur modification après leur initialisation

interface User2 {
    readonly id : number
    name: string
    isActive: boolean
}

let user2: User2 = {
    id: 1,
    name: "Toto",
    isActive: false
}

// user2.id = 2; // Erreur : id est en lecture seule
console.log(user2.id);
user.name = "tata"

// Types alias :

// Un type alias est une autree manière de définir un type personnalisé

type UserOrNull = User | null

let userOne: UserOrNull = null
let userTwo: UserOrNull = {
    id: 1,
    name: "Toto",
    isActive: true
}

type Status = "active" | "inactive" | "suspendu"

let userStatus : Status = "active"
// let userStatus2 : Status = "en cours" // Erreur

// Intersection: Combine plusieurs types ensembles

type Admin = {
    adminLevel: number
    mdp: string
}

type AdminUser = User & Admin

let admin: AdminUser = {
    id:1,
    name: "John",
    isActive: true,
    adminLevel: 3,
    mdp: "123"
}