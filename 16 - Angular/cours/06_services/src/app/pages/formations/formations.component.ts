import { Component, OnInit } from '@angular/core';
import { FormationsService } from '../../utils/services/formations.service';
import { Formation } from '../../utils/types/formation.type';
import { LifecycleComponent } from '../../components/lifecycle/lifecycle.component';

@Component({
  selector: 'app-formations',
  standalone: true,
  imports: [LifecycleComponent],
  templateUrl: './formations.component.html',
  styleUrl: './formations.component.css'
})
export class FormationsComponent implements OnInit {
  formations: Formation[] = []


  constructor(private formationService: FormationsService) {}

  ngOnInit(): void {
    this.formations = this.formationService.formations
  }

  addForm() : void {
    this.formationService.addFormation({
      title: "test",
      duration: 5,
      trainer: {firstname: 'toto', lastname: 'Doe'},
      modules: ['HTML', 'TS']
    })
  }

  // refresh() : void {
  //   this.formations = this.formationService.formations
  // }
}
