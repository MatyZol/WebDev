import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Observable} from 'rxjs';
import {Book} from '../_model/book';

@Injectable({
  providedIn: 'root'
})
export class BookAuthorClient {


  private readonly rootUrl: string = 'http://localhost:8082/api/bookAuthor';

  constructor(private http: HttpClient) {

  }

  public connect(book:Book):Observable<Book>{
    return this.http.post<Book>(this.rootUrl, book);
  }


}
