
export type ListeAttaqueType = {
  nomAttaque: string;
  descriptionAttaque: string;
  degat: number;
}

export type ZoneType = {
  nomZone: string;
  region: string;
}

export type PokemonType = {
  nom: string;
  description: string;
  listeDeTypes: string[];
  listeAttaques: ListeAttaqueType[];
  zones: ZoneType;
}
