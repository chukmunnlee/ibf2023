import { Component, OnDestroy, OnInit, inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription, debounceTime, from, map, tap } from 'rxjs';
import { HttpService } from './http.service';
import { Customer } from './models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit, OnDestroy {

  //private fb = inject(FormBuilder)

  form!: FormGroup

  sub$!: Subscription
  status$!: Subscription

  formStatus = 'INVADLI'

  constructor(private readonly fb: FormBuilder
      , private readonly httpSvc: HttpService) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      name: this.fb.control('', [ Validators.required, Validators.minLength(3) ])
    })

    /*
    this.sub$ = this.form.valueChanges
      .pipe(
        debounceTime(500),
        map(
          value => {
            return { ...value, timestamp: (new Date()) }
          }
        )
      )
      .subscribe(
        {
          next: (value) => {
            console.info('>> form value: ', value)
          },
          error: (error) => {
            console.error('ERROR ', error)
          },
          complete: () => {
            console.info('observable closed')
          }
        }
      )

      this.status$ = this.form.statusChanges.subscribe(
        status => this.formStatus = status
      )
    */
  }

  ngOnDestroy(): void {
      this.sub$.unsubscribe()
      //this.status$.unsubscribe()
  }
  process() {
    console.info('>>> form: ', this.form.value['name'])
    // this.sub$ = this.httpSvc.getHttpBin(this.form.value['name'])
    //   .subscribe(
    //     {
    //       next: result => {
    //         console.info('>>> result: ', result)
    //         this.sub$.unsubscribe()
    //       },
    //       error: error => {
    //         console.error('>>>> observable error: ', error)
    //       },
    //       complete: () => {
    //         console.info('>>>>>> COMPLETE observable closed ')
    //       }
    //     }
    //   )

    // this.httpSvc.getHttpBinAsPromise(this.form.value.name)
    //   .then(result => {
    //     console.info('>>> result from promise: ', result)
    //   })
    //   .catch(error => {
    //     console.error('>>>> ERROR: ', error)
    //   })

    const cust: Customer = {
      name: this.form.value['name'],
      email: this.form.value['name'] + '@gmail.com'
    }
    // this.sub$ = this.httpSvc.postHttpBin(cust)
    //     .subscribe(
    //       result => console.info('POST: ', result)
    //     )

    // this.httpSvc.postHttpBinAsPromise(cust)
    //     .then((result: string) => {
    //       console.info('>>> POST form result: ', result)
    //     })

    // Promise -> Observable
    this.sub$ = from(this.httpSvc.postHttpBinAsPromise(cust))
      .subscribe({
        next: value => console.info('>>> promise -> observable: ', value),
        error: value => console.error('>>> ERROR promise -> observable: ', value),
        complete: () => console.info('>>>> COMPLETED')
      })

    this.form.reset()
  }
}
