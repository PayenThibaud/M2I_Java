import { Component } from '@angular/core';
import { FormArray, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-pokemon',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.css'
})
export class PokemonComponent {

  pokeForm = new FormGroup({
    nom: new FormControl(""),
    description: new FormControl(""),
    types: new FormControl([]),
    attacks: new FormArray([
      new FormGroup({
        nom: new FormControl(""),
        description: new FormControl(""),
        degats: new FormControl(0)
      })
    ]),
    zone: new FormGroup({
      nom: new FormControl(""),
      region: new FormControl("")
    })
  })

  get attacks() {
    return this.pokeForm.controls.attacks;
  }

  addAttack() : void {
    this.attacks.push(
      new FormGroup({
        nom: new FormControl(""),
        description: new FormControl(""),
        degats: new FormControl(0)
      })
    )
  }

  onSubmit(): void {
    console.log(this.pokeForm.value);
    this.pokeForm.reset()
  }

  types: string[] = [
    "feu",
    "vol",
    "psy",
    "poison",
    "eau",
    "roche",
    "normal",
    "plante",
    "electrik",
    "fee",
    "dragon"
  ]
}
