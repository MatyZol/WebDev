import {Component, OnInit} from '@angular/core';
import {StudentClient} from '../../_service/student-client';
import {ActivatedRoute, Router} from '@angular/router';
import {Student} from '../../_model/student';
import {Observable} from 'rxjs';
import {FormsModule} from '@angular/forms';
import {DatePipe, JsonPipe, KeyValuePipe} from '@angular/common';
import {neptunConfig} from '../../appconstans';


@Component({
  selector: 'app-student-edit-component',
  imports: [
    FormsModule,
    JsonPipe,
    KeyValuePipe,
    DatePipe
  ],
  templateUrl: './student-edit-component.html',
  styleUrl: './student-edit-component.scss'
})
export class StudentEditComponent implements OnInit {

  protected student!: Student;

  constructor(
    private client: StudentClient,
    private route: ActivatedRoute,// az aktuálisan aktivált útvonalat írja le
    private router:Router // átirányítást tudunk vele végezni
  ) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      if (params.get('neptun') == 'create') {
        // this.student = new Student(); egyik megközelítés
        this.student = {} as Student;  // ez a másik, itt már tudunk több dolgot is megadni pl.: neptunkód
      } else {
        this.client.get(params.get('neptun')!).subscribe(student => {
          this.student = student;
        });

      }
    })
  }


  protected create(): void {
    this.client.create(this.student).subscribe({
      next: student => {
        this.student = student;
        alert("sikeres létrehozás");
        this.router.navigate(['student',student.neptun]);
      }, error: error => {
        alert(JSON.stringify(error));
      }

    })
  }

  protected update(): void {
    this.client.update(this.student).subscribe({
      next: student => {
        this.student = student;
        alert("sikeres módosítás");
      }, error: error => {
        alert(JSON.stringify(error));
      }

    })
  }

  protected readonly neptunConfig = neptunConfig;


}
