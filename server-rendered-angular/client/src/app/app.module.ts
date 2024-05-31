import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    {
      provide: 'INIT_DATA',
      // @ts-ignore
      useFactory: () => window.INIT_DATA
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
