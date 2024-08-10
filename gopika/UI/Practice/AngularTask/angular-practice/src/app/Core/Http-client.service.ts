import { ITrade } from './../models/trade';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root',
})
export class HttpClientService {
  constructor(private _http: HttpClient) {}

  get<T>(api: string): Observable<T> {
    return this._http.get<T>(api);
  }
  multipleEndpoint() {
    //nested subscription
    //   return this._http.get('https://jsonplaceholder.typicode.com/posts/1')
    //   .subscribe((result: any)=>{
    //       const userId = result.userId
    //       console.log("user id : " + userId)
    //       this._http
    //       .get('https://jsonplaceholder.typicode.com/users/'+userId)
    //       .subscribe(userDetails=>{
    //         console.log("user details");
    //        console.log(userDetails)
    //       })
    //   });
  }
}
