import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { CityComponent } from './components/city.component';
import { WeatherComponent } from './components/weather.component';
import {WeatherService} from './weather.service';

@NgModule({
  declarations: [
    AppComponent,
    CityComponent, WeatherComponent
  ],
  imports: [ BrowserModule, ReactiveFormsModule, HttpClientModule ],
  providers: [ WeatherService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
