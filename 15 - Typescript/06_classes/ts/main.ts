class User {
    // Propriétés 
    id: number
    name: string
    email: string

    // Constructeur
    constructor(id: number, name: string, email: string){
        this.id = id
        this.name = name
        this.email = email
    }

    // Méthodes
    getDetails(): string {
        return `ID: ${this.id}, Name: ${this.name}, Email: ${this.email}`
    }
}

// Instanciation de la classe
let user = new User(1, "Toto", "toto@email.fr")

// Modificateurs d'accès
// TypeScript supporte les modificateurs d'accès pour contrôler la visibilité
// des propriétés et méthodes d'une classe

// public : Par défaut, toutes les méthodes en publique sont accéssibles à l'intérieur
//  et à l'extérieur de la classe
// private : Les membres marqués comme privé ne sont accessible uniquement à l'intérieur de la classe
// protected : Similaire à private, mais les membres protégés sont également accessible
// dans les classes dérivées.
// Les propriétés peuvent être marquées en 'readonly';
// ce qui signifie qu'elles ne peuvent être assignées qu'une seule fois

class User2 {
    readonly id : number
    private name : string
    protected email : string
}