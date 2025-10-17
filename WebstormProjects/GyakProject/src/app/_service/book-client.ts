import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from '../_model/book';

@Injectable({
  providedIn: 'root'
})
export class BookClient {

  private readonly rootUrl: string = 'http://localhost:8082/api/books';

  constructor(private http: HttpClient) {

  }

  public findAll():Observable<Book[]>{
    return this.http.get<Book[]>(this.rootUrl);
  }

  public getOne():Observable<Book>{
    return this.http.get<Book>('http://localhost:8082/api/books/ISBN 1-87225-619-8');
  }
}
