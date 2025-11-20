import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {StudentClient} from '../../_service/student-client';
import {Student} from '../../_model/student';
import {DatePipe, JsonPipe} from '@angular/common';
import {neptunConfig} from '../../appconstans';
import {RouterLink} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {StudentPipe} from '../../_pipe/student-pipe';
import {EmptyRow} from '../empty-row/empty-row';
import {SortableTh} from '../sortable-th/sortable-th';
import {SortableThV2} from '../sortable-th-v2/sortable-th-v2';

@Component({
  selector: 'app-student-list-component',
  imports: [
    DatePipe,
    RouterLink,
    FormsModule,
    StudentPipe,
    EmptyRow,
    SortableTh,
    SortableThV2
  ],
  templateUrl: './student-list-component.html',
  styleUrl: './student-list-component.scss'
})
export class StudentListComponent implements OnInit {

  protected students!: Student[];
  protected searchTerm!: string;
  protected orderBy!: keyof Student;
  protected desc!:boolean;


  constructor(private client: StudentClient) {
  }

  ngOnInit(): void {
    this.client.findAll().subscribe(
      {
        next: response => {
          this.students = response;
        }
      }
    )
  }

  protected order =
    (value: keyof Student):void => {
    if (value==this.orderBy){
      this.desc = !this.desc;
    }else{
      this.desc = false;
      this.orderBy = value
    }
  }

  protected delete(neptun: string):void {
    this.client.delete(neptun)
    .subscribe(response => {
      this.ngOnInit();
    });
  }


  protected readonly neptunConfig = neptunConfig;
}
