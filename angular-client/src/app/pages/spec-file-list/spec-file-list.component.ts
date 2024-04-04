import { Component } from '@angular/core';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from '@angular/common/http';
import { NgFor } from '@angular/common';
import { SpecificationFile } from '../../models/specification-file/specification-file';
import { SpecificationFileService } from '../../services/specification-file/specification-file.service';
import { NavbarComponent } from '../navbar/navbar.component';
import { Router } from '@angular/router';

/**
 * @title List with sections
 */
@Component({
  selector: 'app-spec-file-list',
  standalone: true,
  imports: [
    MatListModule,
    MatIconModule,
    MatDividerModule,
    MatButtonModule,
    NgFor,
    NavbarComponent
  ],
  templateUrl: './spec-file-list.component.html',
  styleUrl: './spec-file-list.component.css',
})
export class SpecFileListComponent {
  speclist : SpecificationFile[] = [];
  // this variable is get data from model
  newRole : SpecificationFile = new SpecificationFile();
  // this variable determines wither we are in changing or creating new user
  creatingMode : boolean = true;

  fileName = '';
  downloadFile: Blob | undefined;

  constructor(private http: HttpClient, private router: Router, private specificationService: SpecificationFileService) {
    this.getSpecFilesByUser();
  }

  getSpecFilesByUser(){
    this.specificationService.get(localStorage.getItem("userId") ?? '').subscribe((response: SpecificationFile[])=>{
      this.speclist = response;
    });
  }

  uploadFile(){
    let app = document.getElementById('hidden-button');
    app?.click();
  }

  onFileSelected(event: any) {

    const file: File = event.target.files[0];
    let userId: string = localStorage.getItem("userId") ?? '';

    if(file){
      this.fileName = file.name;
      const formData = new FormData();
      formData.append("file", file);
      let url = "http://localhost:8080/api/specifications"

      //TODO change to take in userid
      let options: Object = {
        observe: "response",
        responseType: 'text',
        params: {"userId": userId},
      }

      let response = this.http.post(url, formData, options);

      response.subscribe({
        next: (data: any) => {

          //We can view the headers from the response, which come in the form of a map.
          let respHeaders = data.headers;
          let keys = respHeaders.keys();

          let fileName: string | null = "file.txt"; 
          let fileBody: string | null = data.body;
          this.downloadFile = new Blob([fileBody as string], {type: "text/plain"});
        },
        error: (error: HttpErrorResponse) => {
          alert(error.message);
        },
      });
    }
    else{
      alert("No file selected!");
      return;
    }

    this.getSpecFilesByUser();
    window.location.reload();
  }

  routeToRecordsBySpec(specFileId: string){
    localStorage.setItem("specFileId", specFileId);
    this.router.navigateByUrl('/specification-files/records');
  }

}
