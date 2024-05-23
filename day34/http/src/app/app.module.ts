import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpService } from './http.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [ BrowserModule, ReactiveFormsModule, HttpClientModule ],
  providers: [ HttpService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
