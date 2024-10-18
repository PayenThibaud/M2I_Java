import {Component, EventEmitter, Input, Output} from '@angular/core';
import {PokemonType} from '../../utils/types/pokemon_type';

// interface IListeAttaque {
//   nomAttaque: string;
//   descriptionAttaque: string;
//   degat: number;
// }
//
// interface IZone {
//   nomZone: string;
//   region: string;
// }
//
// interface IPokemon {
//   nom: string;
//   description: string;
//   listeDeTypes: string[];
//   listeAttaques: IListeAttaque[];
//   zones: IZone;
// }

@Component({
  selector: 'app-pokemon-card',
  standalone: true,
  imports: [],
  templateUrl: './pokemon-card.component.html',
  styleUrl: './pokemon-card.component.css'
})
export class PokemonCardComponent {
  @Input() pokemon!: PokemonType;

  @Output() dataEmited = new EventEmitter<string>();

  sendData() {
    this.dataEmited.emit("hello depuis pokemon card")
  }
}

