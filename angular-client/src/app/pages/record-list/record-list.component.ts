import { Component } from '@angular/core';
import { Record } from '../../models/record/record';
import { RecordService } from '../../services/record/record.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-record-list',
  standalone: true,
  imports: [NgFor],
  templateUrl: './record-list.component.html',
  styleUrl: './record-list.component.css'
})
export class RecordListComponent {
  recordList: Record[] = [];

  constructor(private recordService: RecordService){
    this.getAllRecords();
  }

  getAllRecords(){
    this.recordService.getAll().subscribe((response: Record[])=>{
      this.recordList = response;
      console.log(this.recordList);
    });
  }
}
