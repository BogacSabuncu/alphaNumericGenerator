import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http:HttpClient) { }
  url = "https://jsonplaceholder.typicode.com/users";

  url2 = "http://localhost:8080/alphaNumeric/";

  test(){
    return this.http.get<any>(this.url)
  }

  getComb(phone:string){
    return this.http.get<any>(this.url2+phone)
  }

}