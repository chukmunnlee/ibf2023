import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { PolarBearService } from './polarbear.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  private readonly router = inject(Router)
  private readonly polarbearSvc = inject(PolarBearService)

  dogBreeds = [ 'mastiff', 'labrador' ]

  polarbear() {
    this.polarbearSvc.image = "/assets/polarbear.jpeg"
    this.router.navigate(['/polarbear'])
  }

  bigCat() {

    const queryParams = { size: 300 }

    this.router.navigate([ '/cat' ], { queryParams })

  }
}
