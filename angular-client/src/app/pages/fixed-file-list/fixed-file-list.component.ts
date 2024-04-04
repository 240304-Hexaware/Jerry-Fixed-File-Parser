import { Component } from '@angular/core';
import { FixedFile } from '../../models/fixed-file/fixed-file';
import { FixedFileService } from '../../services/fixed-file/fixed-file.service';
import { NgFor } from '@angular/common';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { MatButton } from '@angular/material/button';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-fixed-file-list',
  standalone: true,
  imports: [NgFor,MatButton, NavbarComponent],
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
    this.getAllFixedFilesByUser();
  }

  getAllFixedFilesByUser() {
    let userId: string = localStorage.getItem("userId") ?? '';
    this.fixedFileService.get(userId).subscribe((response: FixedFile[]) => {
      this.fixedFileList = response;
    });
  }
}
