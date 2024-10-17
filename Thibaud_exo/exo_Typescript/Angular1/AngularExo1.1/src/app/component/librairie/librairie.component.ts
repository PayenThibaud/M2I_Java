import {Component} from '@angular/core';
import {PoucePipe} from '../../utils/pipes/pouce.pipe';
import {FormsModule} from '@angular/forms';

interface Book {
  titre: string;
  auteur: string;
  isRead: boolean;
}

@Component({
  selector: 'app-librairie',
  standalone: true,
  imports: [
    PoucePipe,
    FormsModule
  ],
  templateUrl: './librairie.component.html',
  styleUrl: './librairie.component.css'
})
export class LibrairieComponent {
  livres: Book[] = [
    {titre: 'livre1', auteur: '1', isRead: false},
    {titre: 'livre2', auteur: '2', isRead: false},
    {titre: 'livre3', auteur: '3', isRead: false},
    {titre: 'livre4', auteur: '4', isRead: false},
    {titre: 'livre5', auteur: '5', isRead: false}
  ];

  toggleIsRead(livre: Book) {
    livre.isRead = !livre.isRead;
  }

  livre: Book = {
    titre: '',
    auteur: '',
    isRead: false
  }

  submitLivre() {
    if (this.livre.titre && this.livre.auteur) {
      this.livres.push({...this.livre});
      this.resetForm();
    }
  }

  resetForm() {
    this.livre = {
      titre: '',
      auteur: '',
      isRead: false
    };


  }
}
