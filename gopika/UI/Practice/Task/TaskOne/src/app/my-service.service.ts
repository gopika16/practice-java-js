import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MyServiceService {

  constructor(private http: HttpClient) { }
  // rootURL = 'http://localhost:5135/Trade/GetTrade?tradeAction=buy'
  private apiUrl = 'http://localhost:5135/Trade/GetTrade?tradeAction=buy';
  fetchBackendData() {
    console.log("gotobackend");
    return this.http.get(this.apiUrl);

  }

}
