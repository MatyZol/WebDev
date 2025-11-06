import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Author} from '../_model/author';

@Injectable({
  providedIn: 'root'
})
export class AuthorClient {

  private readonly rootUrl: string = 'http://localhost:8082/api/author';

  constructor(private http: HttpClient) {
  }

  public findAll():Observable<Author[]>{
    return this.http.get<Author[]>(this.rootUrl);
  }


  public delete(authorID:number):Observable<void>{
    return this.http.delete<void>(`${this.rootUrl}/${authorID}`);
  }
}
