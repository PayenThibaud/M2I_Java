import { Pipe, PipeTransform } from '@angular/core';

type order = "asc" | "desc"

@Pipe({
  name: 'sort',
  standalone: true
})
export class SortPipe implements PipeTransform {

  transform(value: string[], order: order): string[] {
    return order === "asc" ? [...value].sort() : [...value].sort().reverse();
  }

}
