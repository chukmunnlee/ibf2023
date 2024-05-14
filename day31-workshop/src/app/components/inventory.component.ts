import { Component, Input, Output } from '@angular/core';
import { Inventory } from '../models';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrl: './inventory.component.css'
})
export class InventoryComponent {

  @Input()
  inventories: Inventory[] = []

  @Output()
  onSelection = new Subject<number>()

  selected(idx: number) {
    console.info('>>> Index: ', idx)
    this.onSelection.next(idx)
  }

  selectByName(name: string) {
    console.info('>>> name: ', name)
  }

}
