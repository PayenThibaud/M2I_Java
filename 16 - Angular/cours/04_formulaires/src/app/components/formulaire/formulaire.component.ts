import { Component } from '@angular/core';
import { FormArray, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';


type User = {
  name: string
  email: string
  password: string
}

@Component({
  selector: 'app-formulaire',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './formulaire.component.html',
  styleUrl: './formulaire.component.css'
})
export class FormulaireComponent {
  message: string = ""
  message2: string = ""
  isSubmitted : boolean = false

  user : User = {
    name: '',
    email: '',
    password: ''
  }

  submitUser() : void {
    this.isSubmitted = true
    if (!this.passwordHasError){
      console.log(this.user);
    }
  }

  updateMessage(event: Event) : void {
    const input = event.target as HTMLInputElement
    this.message = input.value
  }

  get passwordHasError() {
    return this.isSubmitted && this.user.password.length < 6
  }

  // Reactive forms
  book_control: FormControl = new FormControl('', [
    Validators.required,
    Validators.minLength(2)
  ])

  saveBook(): void {
    if (this.book_control.valid) {
      console.log('Livre ajouté :', this.book_control.value);
    }
  }

  // Form group :

  formation_form: FormGroup = new FormGroup(
    {
      title: new FormControl("", [Validators.required]),
      duration: new FormControl(0, [Validators.required]),
      trainer: new FormGroup({
        firstname: new FormControl(''),
        lastname: new FormControl('')
      }),
      modules: new FormArray([new FormControl(""), new FormControl("")])
    }, [Validators.required]
  )

  // get title() {
  //   return this.formation_form.controls['title'];
  // }

  // get duration() {
  //   return this.formation_form.controls['duration'];
  // }

  get modules() {
    return this.formation_form.controls['modules'] as FormArray;
  }

  addModule(): void{
    this.modules.push(new FormControl(""))
  }

  save_formation() : void {
    if(this.formation_form.valid) {    
      console.log('Sauvegarde de la formation', this.formation_form.value);
      this.formation_form.reset()
    }
  }
}
