import { Pipe, PipeTransform } from '@angular/core';

type order = "asc" | "desc"


@Pipe({
  name: 'trie',
  standalone: true
})
export class TriePipe implements PipeTransform {


  transform(value: string[], order: order): string[] {
    return order === "asc" ? [...value].sort() : [...value].sort().reverse();
  }


}

