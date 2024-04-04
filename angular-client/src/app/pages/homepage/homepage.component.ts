import { Component } from '@angular/core';
import { SpecFileListComponent } from '../spec-file-list/spec-file-list.component';

@Component({
  selector: 'app-homepage',
  standalone: true,
  imports: [
    SpecFileListComponent,
  ],
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css'
})
export class HomepageComponent {

}
