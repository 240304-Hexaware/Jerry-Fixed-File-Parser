import { Component } from '@angular/core';
import { FixedFile } from '../../models/fixed-file/fixed-file';
import { FixedFileService } from '../../services/fixed-file/fixed-file.service';
import { NgFor } from '@angular/common';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { MatButton } from '@angular/material/button';

@Component({
  selector: 'app-fixed-file-list',
  standalone: true,
  imports: [NgFor,MatButton],
  templateUrl: './fixed-file-list.component.html',
  styleUrl: './fixed-file-list.component.css',
})
export class FixedFileListComponent {
  fixedFileList: FixedFile[] = [];
  newFixedFile: FixedFile = new FixedFile();

  fileName = '';
  downloadFile: Blob | undefined;

  constructor(
    private http: HttpClient,
    private fixedFileService: FixedFileService
  ) {
    this.getAllFixedFiles();
  }

  getAllFixedFiles() {
    this.fixedFileService.getAll().subscribe((response: FixedFile[]) => {
      this.fixedFileList = response;
      console.log(this.fixedFileList);
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

      //TODO change to take in userid and specfileId
      let options: Object = {
        observe: 'response',
        responseType: 'text',
        params: {
          userId: '6605cf6280e08c0a76c0c12b',
          specFileId: '6605d50c6335006e44efdeaa',
        },
      };

      let response = this.http.post(url, formData, options);

      response.subscribe({
        next: (data: any) => {
          console.log('data: ', data);

          //We can view the headers from the response, which come in the form of a map.
          let respHeaders = data.headers;
          let keys = respHeaders.keys();
          for (let key of keys) {
            console.log(key, respHeaders.get(key));
          }

          let fileName: string | null = 'file.txt';
          let fileBody: string | null = data.body;
          this.downloadFile = new Blob([fileBody as string], {
            type: 'text/plain',
          });
        },
        error: (error: HttpErrorResponse) => {
          console.log('error: ', error);
          alert(error.message);
        },
        complete: () => {
          console.log('Http response complete!');
        },
      });
    } else {
      alert('No file selected!');
      return;
    }

    this.getAllFixedFiles();
    window.location.reload();
  }
}
