import { Component, Inject, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  protected message = 'not set'

  constructor(@Inject('INIT_DATA') protected initData: any) { }

  ngOnInit(): void {
    console.info('>>> message: ', this.message)
    console.info('>>> initData: ', typeof this.initData)
    this.message = this.initData.message
  }
}
