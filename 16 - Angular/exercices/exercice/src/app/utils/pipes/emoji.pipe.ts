import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'emoji',
  standalone: true
})
export class EmojiPipe implements PipeTransform {

  transform(value: boolean): string {
    return value ? '👍' : '👎';
  }
}
