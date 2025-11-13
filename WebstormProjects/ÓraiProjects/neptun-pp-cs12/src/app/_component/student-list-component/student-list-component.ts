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

@Component({
  selector: 'app-student-list-component',
  imports: [
    JsonPipe,
    DatePipe,
    RouterLink,
    FormsModule,
    StudentPipe,
    EmptyRow
  ],
  templateUrl: './student-list-component.html',
  styleUrl: './student-list-component.scss'
})
export class StudentListComponent implements OnInit {

  protected students!: Student[];
  protected searchTerm!: string;


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

  protected delete(neptun: string):void {
    this.client.delete(neptun)
    .subscribe(response => {
      this.ngOnInit();
    });
  }


  protected readonly neptunConfig = neptunConfig;
}
