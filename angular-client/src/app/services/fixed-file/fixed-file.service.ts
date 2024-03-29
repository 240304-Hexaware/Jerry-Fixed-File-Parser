import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FixedFileService {
  
  SpecAPIUrl ="http://localhost:8080/api/fixed-files";

  // Inject ApiUrl in constructor to Get it form ather Service
  constructor(private http: HttpClient) { }

  // Get Method
  getAll(): Observable<any> {
    return this.http.get<any>(this.SpecAPIUrl);
  }
  // Get with user id
  get(id: any): Observable<any> {
    return this.http.get(`${this.SpecAPIUrl}/users/${id}`);
  }
  // Create Method
  Create(userId: string, specFileId: string, file: any): Observable<any> {
    let options: Object = {
      observe: "response",
      responseType: 'text',
      params: {
        "userId": userId,
        "specFileId": specFileId,
      },
    }
    return this.http.post(this.SpecAPIUrl, file, options);
  }
}
