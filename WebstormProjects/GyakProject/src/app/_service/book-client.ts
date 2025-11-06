import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from '../_model/book';

@Injectable({
  providedIn: 'root'
})
export class BookClient {

  private readonly rootUrl: string = 'http://localhost:8082/api/book';

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

  public create(book:Book):Observable<Book> {
    return this.http.post<Book>(this.rootUrl, book);
  }

  public update(book:Book):Observable<Book> {
    return this.http.put<Book>(this.rootUrl, book);
  }
}
