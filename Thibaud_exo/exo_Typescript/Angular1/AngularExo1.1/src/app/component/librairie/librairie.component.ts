import { Component } from '@angular/core';

interface Book {
  titre: string;
  auteur: string;
  isRead: boolean;
}

@Component({
  selector: 'app-librairie',
  standalone: true,
  imports: [],
  templateUrl: './librairie.component.html',
  styleUrl: './librairie.component.css'
})
export class LibrairieComponent {
  livres: Book[] = [
    { titre: 'livre1', auteur: '1', isRead: true },
    { titre: 'livre2', auteur: '2', isRead: false },
    { titre: 'livre3', auteur: '3', isRead: true },
    { titre: 'livre4', auteur: '4', isRead: false },
    { titre: 'livre5', auteur: '5', isRead: true }
  ];


}
