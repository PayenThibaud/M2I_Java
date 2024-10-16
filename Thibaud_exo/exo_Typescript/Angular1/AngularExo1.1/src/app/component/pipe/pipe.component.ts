import { Component } from '@angular/core';
import {UppertalePipe} from '../../utils/pipes/uppertale.pipe';
import {TriePipe} from '../../utils/pipes/trie.pipe';

@Component({
  selector: 'app-pipe',
  standalone: true,
  imports: [
    UppertalePipe,
    TriePipe,
  ],
  templateUrl: './pipe.component.html',
  styleUrl: './pipe.component.css'
})
export class PipeComponent {

  tab: string[] = [
    'Breaking Bad',
    'Stranger Things',
    'Game of Thrones',
    'The Witcher',
    'Money Heist'
  ];

  trie: "asc" | "desc" = "asc";


  toggleSortOrder() {
    this.trie = this.trie === "asc" ? "desc" : "asc";
  }
}
