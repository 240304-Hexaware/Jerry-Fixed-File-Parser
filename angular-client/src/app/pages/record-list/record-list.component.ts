import { Component } from '@angular/core';
import { Record } from '../../models/record/record';
import { RecordService } from '../../services/record/record.service';
import { NgFor } from '@angular/common';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-record-list',
  standalone: true,
  imports: [NgFor, NavbarComponent],
  templateUrl: './record-list.component.html',
  styleUrl: './record-list.component.css'
})
export class RecordListComponent {
  recordList: Record[] = [];

  constructor(private recordService: RecordService){
    this.getAllRecordsByUser();
  }

  getAllRecordsByUser(){
    let userId: string = localStorage.getItem("userId") ?? '';
    this.recordService.getAllByUser(userId).subscribe((response: Record[])=>{
      this.recordList = response;
    });
  }
}
