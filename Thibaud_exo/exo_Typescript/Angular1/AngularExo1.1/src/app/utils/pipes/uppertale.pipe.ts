import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'uppertale',
  standalone: true
})
export class UppertalePipe implements PipeTransform {

  transform(value: string[]): string[] {
    return value.map((element) => element.toUpperCase());
  }

}
