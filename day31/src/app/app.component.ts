import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'day31';
  polarBear = "https://i0.wp.com/www.sciencenews.org/wp-content/uploads/2022/11/110122_mr_polar-paw_feat.jpg"

  imgs: string[] = [
    "https://media.newyorker.com/photos/59095e9b019dfc3494e9fb43/master/pass/Frazier-Animal-Mascots-Climate-Change.jpg",
    "https://i0.wp.com/www.sciencenews.org/wp-content/uploads/2022/11/110122_mr_polar-paw_feat.jpg",
    "https://media-cldnry.s-nbcnews.com/image/upload/streams/2014/February/140225/2D11741327-105187-lisa-granshawAAEA3BA7-DBD0-2809-3D75-A303123C3B8F.jpg",
    "https://animals.sandiegozoo.org/sites/default/files/2016-09/animals_hero_polar_bear_1.jpg"
  ]

  handleClick(text: string) {
    console.info('>>>>> image clicked: ', text)
  }
}
