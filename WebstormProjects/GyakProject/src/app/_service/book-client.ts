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

  public delete(isbn:string):Observable<void>{
    return this.http.delete<void>(`${this.rootUrl}/${isbn}`)
  }

  public getOne(isbn:string):Observable<Book>{
    return this.http.get<Book>(`${this.rootUrl}/${isbn}`);
  }
}
