import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { MainComponent } from './views/main.component';
import { CatComponent } from './views/cat.component';
import { DogComponent } from './views/dog.component';
import { PolarbearComponent } from './views/polarbear.component';
import { PolarBearService } from './polarbear.service';

const appRoutes: Routes = [
  { path: '', component: MainComponent },
  { path: 'cat', component: CatComponent},
  { path: 'dog/:breed', component: DogComponent },
  { path: 'polarbear', component: PolarbearComponent },
  // Wildcard, last route
  { path: '**', redirectTo: '/', pathMatch: 'full'}
]

@NgModule({
  declarations: [ AppComponent, MainComponent, CatComponent, DogComponent, PolarbearComponent ],
  imports: [
    BrowserModule, RouterModule.forRoot(appRoutes)
  ],
  providers: [ PolarBearService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
