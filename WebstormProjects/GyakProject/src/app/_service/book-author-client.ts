import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BookAuthor} from '../_model/book-author';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookAuthorClient {


  private readonly rootUrl: string = 'http://localhost:8082/api/bookAuthor';

  constructor(private http: HttpClient) {

  }

  public create(bookAuthor:BookAuthor):Observable<BookAuthor>{
    return this.http.post<BookAuthor>(this.rootUrl, bookAuthor);
  }


}
