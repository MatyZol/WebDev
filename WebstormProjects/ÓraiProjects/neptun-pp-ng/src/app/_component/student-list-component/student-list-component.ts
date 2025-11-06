import {Component, OnInit} from '@angular/core';
import {StudentClient} from '../../_service/student-client';
import {Student} from '../../_model/student';
import {DatePipe, JsonPipe} from '@angular/common';

@Component({
  selector: 'app-student-list-component',
  imports: [
    JsonPipe,
    DatePipe
  ],
  templateUrl: './student-list-component.html',
  styleUrl: './student-list-component.scss'
})
export class StudentListComponent
  implements OnInit {

  protected students!: Student[];

  constructor(
    private client: StudentClient
  ) {
  }

  ngOnInit(): void {
    this.client
      .findAll()
      .subscribe({
        next: response => {
          this.students = response;
        }
      });
  }

  protected delete(neptun: string): void {
    this.client
      .delete(neptun)
      .subscribe(response => {
        this.ngOnInit();
      })
  }
}
