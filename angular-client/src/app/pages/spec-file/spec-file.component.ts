import { Component } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';

@Component({
  selector: 'app-spec-file',
  standalone: true,
  imports: [
    MatIconModule,
    MatListModule,
  ],
  templateUrl: './spec-file.component.html',
  styleUrl: './spec-file.component.css'
})
export class SpecFileComponent {

}
