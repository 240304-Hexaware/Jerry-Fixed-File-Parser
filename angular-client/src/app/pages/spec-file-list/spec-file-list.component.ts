import { Component } from '@angular/core';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { SpecFileComponent } from '../spec-file/spec-file.component';
import { HttpClient } from '@angular/common/http';

export interface Section {
  name: string;
}

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
    SpecFileComponent,
  ],
  templateUrl: './spec-file-list.component.html',
  styleUrl: './spec-file-list.component.css',
})
export class SpecFileListComponent {
  specFiles: Section[] = [
    {
      name: 'Photos',
    },
    {
      name: 'Recipes',
    },
    {
      name: 'Work',
    },
    {
      name: 'Vacation Itinerary',
    },
    {
      name: 'Kitchen Remodel',
    },
  ];

  fileName = '';

  constructor(private http: HttpClient) {}
  
  uploadFile(){
    let app = document.getElementById('hidden-button');
    app?.click();
  }

  onFileSelected(event: any) {

    const file: File = event.target.files[0];

    if(file){
      this.fileName = file.name;
      const formData = new FormData();
      formData.append("specFile", file);

      const upload$ = this.http.post("/api", formData);

      upload$.subscribe();
    }
  }
}
