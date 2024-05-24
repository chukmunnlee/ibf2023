import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SearchComponent } from './views/search.component';
import { ListGamesComponent } from './views/list-games.component';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { GamesService } from './games.service';
import { GameDetailsComponent } from './views/game-details.component';

const appRoutes: Routes = [
  { path: '', component: SearchComponent },
  { path: 'games', component: ListGamesComponent },
  { path: 'game/:gameId', component: GameDetailsComponent },
  { path: '**', redirectTo: '/', pathMatch: 'full' }
]

@NgModule({
  declarations: [
    AppComponent, SearchComponent, ListGamesComponent, GameDetailsComponent
  ],
  imports: [
    BrowserModule, ReactiveFormsModule, HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [ GamesService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
