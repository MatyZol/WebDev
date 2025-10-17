import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Student} from '../_model/student';

@Injectable({
  providedIn: 'root'
})
export class StudentClient {
  private readonly rootUrl:string = 'http://localhost:8081/api/student';

  constructor(
    private http: HttpClient
  ) {
  }

  public findAll():Observable<Student[]>{
    return this.http.get<Student[]>(this.rootUrl);
  }

}
