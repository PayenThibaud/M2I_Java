import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MerchService } from '../../utils/services/merch.service';
import { Merch } from '../../utils/types/merch.type';

@Component({
  selector: 'app-add-merch',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './add-merch.component.html',
  styleUrl: './add-merch.component.css',
})
export class AddMerchComponent {
  merchForm = new FormGroup({
    name: new FormControl(''),
    description: new FormControl(''),
    price: new FormControl(0),
    stock: new FormControl(0),
  });

  constructor(private merchService: MerchService) {}

  handleSubmit() {
    const id = this.merchService.generateId();
    this.merchService.add({ id, ...this.merchForm.value } as Merch);
    this.merchForm.reset();
  }
}
