import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'trie',
  standalone: true
})
export class TriePipe implements PipeTransform {

  transform(value: string[], order: 'asc' | 'desc'): string[] {
    const sortedArray = [...value].sort((a, b) => {
      return order === 'asc' ? a.localeCompare(b) : -a.localeCompare(b);
    });
    return sortedArray;
  }


}

