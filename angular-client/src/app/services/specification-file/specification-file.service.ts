import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SpecificationFileService {

  SpecAPIUrl ="http://localhost:8080/api/specifications";
  userId = "6605cf6280e08c0a76c0c12b";

  // Inject ApiUrl in constructor to Get it form another Service
  constructor(private http: HttpClient) { }

  // Get with id
  get(id: any): Observable<any> {
    return this.http.get(`${this.SpecAPIUrl}/${id}`);
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
