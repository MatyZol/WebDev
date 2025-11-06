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

  public delete(neptun: string):Observable<void>{
    return this.http.delete<void>(`${this.rootUrl}/${neptun}`);
  }

  get(neptun: string):Observable<Student> {
    return this.http.get<Student>(`${this.rootUrl}/${neptun}`);
  }

  create(student: Student):Observable<Student>{
    return this.http.post<Student>(this.rootUrl, student);
  }

  update(student: Student):Observable<Student>{
    return this.http.put<Student>(this.rootUrl, student);
  }

}
