import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { Observable, firstValueFrom, lastValueFrom, map } from "rxjs";
import { Customer } from "./models";

@Injectable()
export class HttpService {

  // RestTemplate
  private readonly http = inject(HttpClient)

  //constructor(private readonly http: HttpClient) { }

  getHttpBin(name = 'abc'): Observable<any> {
    console.info('>>> name: ', name)
    const params = new HttpParams()
        .set('name', name)
        .set('timestamp', (new Date().toISOString()))

    console.info('>>> params: ', params)

    const headers = new HttpHeaders()
      .set('X-MY-HEADER', 'fred')

    return this.http.get<any>('https://httpbin.orgx/get'
      , { params, headers: headers }
    )
  }

  postHttpBin(cust: Customer) {
    // Don't have to do this, default is JSON payload
    const headers = new HttpHeaders()
      .set('Content-Type', 'applicaton/json')

    return this.http.post<any>('https://httpbin.org/post', cust, { headers })
  }

  postHttpBinAsPromise(cust: Customer) {
    const headers = new HttpHeaders()
      .set('Content-Type', 'applicaton/x-www-form-urlencoded')

    // <input type="text" name="name" value="fred">
    // <input type="text" name="email" value="fred@gmail.com">
    const fields = new HttpParams()
        .set('name', cust.name)
        .set('email', cust.email)

    return firstValueFrom<string>(
      this.http.post<any>('https://httpbin.org/post'
          , fields.toString(), { headers })
        .pipe(
          map(result => result['data'])
        )
    )
  }

  getHttpBinAsPromise(name = 'abc'): Promise<any> {
    console.info('>>> name: ', name)
    const params = new HttpParams()
        .set('name', name)
        .set('timestamp', (new Date().toISOString()))

    console.info('>>> params: ', params)

    const headers = new HttpHeaders()
      .set('X-MY-HEADER', 'fred')

    return lastValueFrom(
      this.http.get<any>('https://httpbin.com/get'
        , { params, headers: headers })
    )
  }

}
