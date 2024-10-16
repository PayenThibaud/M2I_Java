import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pouce',
  standalone: true
})
export class PoucePipe implements PipeTransform {
  transform(isRead: boolean): string {
    return isRead ? '⭕' : '❌';
  }
}
