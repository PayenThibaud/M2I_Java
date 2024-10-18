import { Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-lifecycle',
  standalone: true,
  imports: [],
  templateUrl: './lifecycle.component.html',
  styleUrl: './lifecycle.component.css'
})
export class LifecycleComponent implements OnChanges, OnInit, OnDestroy {
  @Input() data: string = ""

  ngOnChanges(changes: SimpleChanges): void {
    console.log("On change :", changes);
    const previous = changes['data'].previousValue
    console.log(previous);
    const newValue = changes['data'].currentValue
    console.log(newValue);
    const isFirstChange = changes['data'].isFirstChange()
    console.log(isFirstChange);
  }

  ngOnInit(): void {
    console.log('On Init');
  }

  ngOnDestroy(): void {
    console.log("On destroy");
  }
}
