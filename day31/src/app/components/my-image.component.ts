import { Component, Input, Output } from '@angular/core';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-my-image',
  templateUrl: './my-image.component.html',
  styleUrl: './my-image.component.css'
})
export class MyImageComponent {

  @Input()
  imageUrl: string = '/assets/polarbear.jpg'

  @Input()
  caption: string = 'My picture'

  @Output()
  onFigureClicked = new Subject<string>()

  counter: number = 0

  imageClicked(abc: any) {
    console.info('>>>> my image  component clicked ', abc)
    this.counter++
    // fire the event
    this.onFigureClicked.next(this.caption)
  }

}
