import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SpecificationFileService {

  SpecAPIUrl ="http://localhost:8080/api/specifications";

  // Inject ApiUrl in constructor to Get it form another Service
  constructor(private http: HttpClient) { }

  // Get with id
  get(userId: string): Observable<any> {
    let url: string = this.SpecAPIUrl + "/" + userId;
    return this.http.get(url);
  }

  getAll(): Observable<any> {
    return this.http.get(this.SpecAPIUrl);
  }
  
  // Create Method
  Create(userId: string, file: any): Observable<any> {
    let options: Object = {
      observe: "response",
      responseType: 'text',
      params: {"userId": userId},
    }
    return this.http.post(this.SpecAPIUrl, file, options);
  }
}
