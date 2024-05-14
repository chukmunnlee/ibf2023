import { Component } from '@angular/core';
import { Inventory } from './models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'day31-workshop';

  myInventories: Inventory[] = [
    {
      url: '/assets/fruits/apple.png',
      name: "Apple"
    },
    {
      url: '/assets/fruits/blueberries.png',
      name: "Blueberries"
    },
    {
      url: '/assets/fruits/celery.png',
      name: "Celery"
    },
  ]

  // List<String> selections
  selections: string[] = []

  inventorySelected(idx: number) {
    console.info('>>> selection: ', this.myInventories[idx])
    this.selections.push(this.myInventories[idx].name)
  }
}
