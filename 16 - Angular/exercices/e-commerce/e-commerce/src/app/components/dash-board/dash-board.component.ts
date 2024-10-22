import { Component, OnInit } from '@angular/core';
import { MerchService } from '../../utils/services/merch.service';
import { Merch } from '../../utils/types/merch.type';

@Component({
  selector: 'app-dash-board',
  standalone: true,
  imports: [],
  templateUrl: './dash-board.component.html',
  styleUrl: './dash-board.component.css',
})
export class DashBoardComponent implements OnInit {
  merchList: Merch[] = [];

  constructor(private merchService: MerchService) {}

  ngOnInit(): void {
    this.merchList = this.merchService.merchList;
  }

  remove(merch: Merch) {
    this.merchService.remove(merch);
  }
}
