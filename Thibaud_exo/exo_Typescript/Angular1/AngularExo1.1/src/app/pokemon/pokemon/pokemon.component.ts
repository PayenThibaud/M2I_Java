import { Component } from '@angular/core';
import { FormArray, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import {of} from 'rxjs';

interface IListeAttaque {
  nomAttaque: string;
  descriptionAttaque: string;
  degat: number; // Changement du type en number
}

interface IZone {
  nomZone: string;
  region: string;
}

interface IPokemon {
  nom: string;
  description: string;
  listeDeTypes: string[];
  listeAttaques: IListeAttaque[];
  zones: IZone;
}

@Component({
  selector: 'app-pokemon',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.css']
})
export class PokemonComponent {
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
      this.pokemon_form.reset();
    }
  }
}
