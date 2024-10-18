import { Component } from '@angular/core';
import { FormArray, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import {PokemonCardComponent} from '../pokemon-card/pokemon-card.component';
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
  selector: 'app-pokemon',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, PokemonCardComponent],
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.css']
})
export class PokemonComponent {

  listePokemon: PokemonType[] = [
    {
      nom: 'Pikachu',
      description: 'Un Pokémon de type Électrique très populaire.',
      listeDeTypes: ['Électrique'],
      listeAttaques: [
        { nomAttaque: 'Éclair', descriptionAttaque: 'Un coup de foudre rapide.', degat: 40 },
        { nomAttaque: 'Tonnerre', descriptionAttaque: 'Une attaque électrique puissante.', degat: 90 }
      ],
      zones: { nomZone: 'Forêt de Viridian', region: 'Kanto' }
    },
    {
      nom: 'Bulbizarre',
      description: 'Un Pokémon de type Plante/Poison, calme et résistant.',
      listeDeTypes: ['Plante', 'Poison'],
      listeAttaques: [
        { nomAttaque: 'Fouet Lianes', descriptionAttaque: 'Attaque avec des lianes puissantes.', degat: 45 },
        { nomAttaque: 'Canon Graine', descriptionAttaque: 'Projette des graines à grande vitesse.', degat: 50 }
      ],
      zones: { nomZone: 'Forêt d’Azuria', region: 'Kanto' }
    },
    {
      nom: 'Dracaufeu',
      description: 'Un puissant Pokémon de type Feu/Vol.',
      listeDeTypes: ['Feu', 'Vol'],
      listeAttaques: [
        { nomAttaque: 'Lance-Flammes', descriptionAttaque: 'Crache des flammes intenses.', degat: 85 },
        { nomAttaque: 'Vol', descriptionAttaque: 'S’élève dans les airs et frappe à grande vitesse.', degat: 70 }
      ],
      zones: { nomZone: 'Île de Cramois\'Île', region: 'Kanto' }
    }
  ];


  pokemon_form: FormGroup = new FormGroup({
    nom: new FormControl("", [Validators.required]),
    description: new FormControl("", [Validators.required]),
    zones: new FormGroup({
      nomZone: new FormControl("", [Validators.required]),
      region: new FormControl("", [Validators.required]),
    }),
    listeDeTypes: new FormArray([new FormControl("")]),
    listeAttaques: new FormArray([
      new FormGroup({
        nomAttaque: new FormControl("", [Validators.required]),
        descriptionAttaque: new FormControl("", [Validators.required]),
        degat: new FormControl("", [Validators.required]),
      })
    ])
  });

  get listeDeTypes() {
    return this.pokemon_form.get('listeDeTypes') as FormArray;
  }

  get listeAttaques() {
    return this.pokemon_form.get('listeAttaques') as FormArray;
  }

  addType(): void {
    this.listeDeTypes.push(new FormControl(""));
  }

  removeType(index: number): void {
    this.listeDeTypes.removeAt(index);
  }

  addAttaque(): void {
    this.listeAttaques.push(new FormGroup({
      nomAttaque: new FormControl("", [Validators.required]),
      descriptionAttaque: new FormControl("", [Validators.required]),
      degat: new FormControl("", [Validators.required]),
    }));
  }

  removeAttaque(index: number): void {
    this.listeAttaques.removeAt(index);
  }

  save_pokemon(): void {
    if (this.pokemon_form.valid) {
      console.log('Sauvegarde du Pokémon', this.pokemon_form.value);
      this.listePokemon.push(this.pokemon_form.value);
      this.pokemon_form.reset();
    }
  }


  receiveData: string = ""

  handleData(data: string): void {
    this.receiveData = data
  }
 }
