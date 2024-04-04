import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FixedFileService {
  
  fixedFileAPIURL ="http://localhost:8080/api/fixed-files";

  // Inject ApiUrl in constructor to Get it form ather Service
  constructor(private http: HttpClient) { }

  // Get Method
  getAll(): Observable<any> {
    return this.http.get<any>(this.fixedFileAPIURL);
  }
  // Get with user id
  get(userId: string): Observable<any> {
    return this.http.get(`${this.fixedFileAPIURL}/users/${userId}`);
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
    return this.http.post(this.fixedFileAPIURL, file, options);
  }
}
