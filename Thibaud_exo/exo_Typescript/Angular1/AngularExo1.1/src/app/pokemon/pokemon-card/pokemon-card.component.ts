import {Component, EventEmitter, Input, Output} from '@angular/core';
import { Pokemon } from '../../utils/types/pokemon_type';
import { CommonModule } from '@angular/common';

type PokemonType =
  "feu" |
  "vol"|
  "psy"|
  "poison"|
  "eau"|
  "roche"|
  "normal"|
  "plante"|
  "electrik"|
  "fee"|
  "dragon"

@Component({
  selector: 'app-pokemon-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './pokemon-card.component.html',
  styleUrl: './pokemon-card.component.css'
})
export class PokemonCardComponent {
  @Input() pokemon!: Pokemon
  @Output() deleteEvent= new EventEmitter<Pokemon>()

  deletePokemon(){
    this.deleteEvent.emit(this.pokemon);
  }

  getTypeColor(type: string) : string {
    console.log(type);
    const typeColors : Record<PokemonType, string> = {
      feu: "bg-red-500",
      vol: "bg-slate-500",
      psy: "bg-pink-500",
      poison: "bg-purple-500",
      eau: "bg-blue-500",
      roche: "bg-gray-500",
      normal: "bg-neutral-500",
      plante: "bg-green-500",
      electrik: "bg-yellow-500",
      fee: "bg-pink-300",
      dragon: "bg-blue-950"
    }

    return typeColors[type as PokemonType] || 'bg-gray-300'
  }

}
