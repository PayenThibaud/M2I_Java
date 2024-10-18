import { Component } from '@angular/core';
import { FormArray, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Pokemon } from '../../utils/types/pokemon.type';
import { PokemonCardComponent } from '../../components/pokemon-card/pokemon-card.component';

@Component({
  selector: 'app-pokemon',
  standalone: true,
  imports: [ReactiveFormsModule, PokemonCardComponent],
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

  pokemonList: Pokemon[] = [
    {
      nom: "Dracaufeu",
      description: "Un Pokémon volant et cracheur de feu.",
      types: ["feu", "vol"],
      attacks: [
        {
          nom: "Lance-Flammes",
          description: "Projette des flammes intenses pour brûler l'ennemi.",
          degats: 90
        },
        {
          nom: "Danse Draco",
          description: "Augmente l'attaque et la vitesse.",
          degats: 0
        }
      ],
      zone: {
        nom: "Mont Braise",
        region: "Kanto"
      }
    },
    {
      nom: "Tortank",
      description: "Un Pokémon tortue doté de canons à eau sur son dos.",
      types: ["eau"],
      attacks: [
        {
          nom: "Hydrocanon",
          description: "Lance un puissant jet d'eau pour submerger l'adversaire.",
          degats: 110
        },
        {
          nom: "Ébullition",
          description: "Inflige des brûlures tout en attaquant.",
          degats: 80
        }
      ],
      zone: {
        nom: "Lac Courage",
        region: "Sinnoh"
      }
    },
    {
      nom: "Gardevoir",
      description: "Un Pokémon capable de voir l'avenir et de protéger son dresseur.",
      types: ["psy", "fee"],
      attacks: [
        {
          nom: "Choc Psy",
          description: "Inflige des dégâts en utilisant la force mentale.",
          degats: 80
        },
        {
          nom: "Pouvoir Lunaire",
          description: "Utilise la lumière de la lune pour infliger de gros dégâts.",
          degats: 95
        }
      ],
      zone: {
        nom: "Forêt de Jade",
        region: "Hoenn"
      }
    }
  ];
}
