import { Component } from '@angular/core';
import { AddMerchComponent } from '../../components/add-merch/add-merch.component';
import { DashBoardComponent } from '../../components/dash-board/dash-board.component';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [AddMerchComponent, DashBoardComponent],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css',
})
export class AdminComponent {}
