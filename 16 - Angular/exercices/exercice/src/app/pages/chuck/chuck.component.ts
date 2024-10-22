import { Component, OnInit } from '@angular/core';
import { ChuckService } from '../../utils/services/chuck.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-chuck',
  standalone: true,
  imports: [],
  templateUrl: './chuck.component.html',
  styleUrl: './chuck.component.css'
})
export class ChuckComponent implements OnInit {
  joke!: string

  constructor(private chuckService: ChuckService) {}

  ngOnInit(): void {
    this.getFact()
  }

  getFact() {
    this.chuckService.getRandomFact().subscribe((data: string) => {
      this.joke = data
    })
  }
}
