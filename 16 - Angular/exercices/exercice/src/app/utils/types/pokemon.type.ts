export type Pokemon = {
    nom: string
    description: string
    types: string[],
    zone: Zone,
    attacks: Attack[]
}

export type Zone = {
    nom: string
    region: string
}

export type Attack = {
    nom: string
    description: string
    degats: number
}