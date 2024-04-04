import { Component } from '@angular/core';
import { Record } from '../../models/record/record';
import { RecordService } from '../../services/record/record.service';
import { NgFor } from '@angular/common';
import { NavbarComponent } from '../navbar/navbar.component';
import { MatButton } from '@angular/material/button';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-records-by-file',
  standalone: true,
  imports: [NgFor, NavbarComponent, MatButton],
  templateUrl: './records-by-file.component.html',
  styleUrl: './records-by-file.component.css'
})
export class RecordsByFileComponent {
  specFileId: string = localStorage.getItem("specFileId") ?? '';

  recordList: Record[] = [];

  fileName = '';
  downloadFile: Blob | undefined;

  constructor(private http: HttpClient, private recordService: RecordService){
    this.getAllRecordsBySpecFile();
  }

  getAllRecordsBySpecFile(){
    this.recordService.getAllBySpecFile(this.specFileId).subscribe((response: Record[])=>{
      this.recordList = response;
    });
  }

  uploadFile() {
    let app = document.getElementById('hidden-button');
    app?.click();
  }

  onFileSelected(event: any) {
    const file: File = event.target.files[0];

    if (file) {
      this.fileName = file.name;
      const formData = new FormData();
      formData.append('file', file);
      let url = 'http://localhost:8080/api/fixed-files';
      let userId: string = localStorage.getItem("userId") ?? '';

      let options: Object = {
        observe: 'response',
        responseType: 'text',
        params: {
          userId: userId,
          specFileId: this.specFileId,
        },
      };

      let response = this.http.post(url, formData, options);

      response.subscribe({
        next: (data: any) => {
          let fileBody: string | null = data.body;
          this.downloadFile = new Blob([fileBody as string], {
            type: 'text/plain',
          });

          alert(JSON.stringify(JSON.parse(data.body), null, 2));
        },
        error: (error: HttpErrorResponse) => {
          alert(error.message);
        },
      });
    } else {
      alert('No file selected!');
      return;
    }

    this.getAllRecordsBySpecFile();
  }
}
