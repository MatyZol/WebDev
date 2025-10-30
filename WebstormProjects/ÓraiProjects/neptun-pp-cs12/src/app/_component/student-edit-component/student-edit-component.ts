import {Component, OnInit} from '@angular/core';
import {StudentClient} from '../../_service/student-client';
import {ActivatedRoute} from '@angular/router';
import {Student} from '../../_model/student';
import {Observable} from 'rxjs';
import {FormsModule} from '@angular/forms';
import {JsonPipe} from '@angular/common';

@Component({
  selector: 'app-student-edit-component',
  imports: [
    FormsModule,
    JsonPipe
  ],
  templateUrl: './student-edit-component.html',
  styleUrl: './student-edit-component.scss'
})
export class StudentEditComponent implements OnInit {

  protected student!: Student;

  constructor(
    private client: StudentClient,
    private route: ActivatedRoute, // az aktuálisan aktivált útvonalat írja le
  ) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      if(params.get('neptun') == 'create'){
        // this.student = new Student(); egyik megközelítés
        this.student = {} as Student;  // ez a másik, itt már tudunk több dolgot is megadni pl.: neptunkód
      }
      else{
        this.client.get(params.get('neptun')!).subscribe(student => {this.student = student;});

      }
    })
  }



}
