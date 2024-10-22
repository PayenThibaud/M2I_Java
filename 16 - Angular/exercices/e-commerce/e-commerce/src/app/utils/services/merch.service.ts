import { Injectable } from '@angular/core';
import { Merch } from '../types/merch.type';

@Injectable({
  providedIn: 'root',
})
export class MerchService {
  merchList: Merch[] = [];
  constructor() {
    const merch = localStorage.getItem('merchList');

    if (merch) {
      this.merchList = JSON.parse(merch);
    }
  }

  saveMerch() {
    localStorage.setItem('merchList', JSON.stringify(this.merchList));
  }

  generateId() {
    return this.merchList.length + 1;
  }

  add(merch: Merch): void {
    if (!this.merchList.includes(merch)) {
      this.merchList.push(merch);
      this.saveMerch();
    } else {
      alert(`L'article ${merch.name} existe déjà`);
    }
  }

  remove(merch: Merch) {
    if (confirm(`Voulez vous vraiment supprimer ${merch.name} ?`)) {
      const index = this.merchList.findIndex((m) => m.id === merch.id);
      if (index >= 0) {
        this.merchList.splice(index, 1);
        this.saveMerch();
      } else {
        alert('Aucun article trouvé');
      }
    }
  }

  changeStock(merch: Merch, stock: number) {
    const index = this.merchList.findIndex((m) => m.id === merch.id);
    if (index >= 0) {
      this.merchList[index].stock += stock;
      this.saveMerch;
    } else {
      alert('Aucun article trouvé');
    }
  }
}
