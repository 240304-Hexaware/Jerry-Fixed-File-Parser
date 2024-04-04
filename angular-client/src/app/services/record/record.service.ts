import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RecordService {
  RecordAPIUrl = 'http://localhost:8080/api/records';

  constructor(private http: HttpClient) {}

  getAllByUser(userId: string): Observable<any> {
    let url: string = this.RecordAPIUrl + "/users/" + userId
    return this.http.get<any>(url);
  }

  getAllBySpecFile(specFileId: string): Observable<any> {
    let url: string = this.RecordAPIUrl + "/spec-files/" + specFileId
    return this.http.get<any>(url);
  }
}
