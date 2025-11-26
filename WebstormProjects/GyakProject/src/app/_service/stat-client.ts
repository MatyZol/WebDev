import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map, Observable} from 'rxjs';
import {AuthorStat, GenreStat, PublisherStat} from '../_model/stat-types';


@Injectable({
  providedIn: 'root'
})
export class StatClient {

  private readonly rootUrl: string = 'http://localhost:8082/';

  constructor(private http: HttpClient) { }



  public getBooksByGenre(): Observable<GenreStat[]> {
    return this.http.get<GenreStat[]>(`${this.rootUrl}stats/by-genre`);
  }


  public getBooksByPublisher(): Observable<PublisherStat[]> {
    return this.http.get<PublisherStat[]>(`${this.rootUrl}stats/by-publisher`);
  }


  public getBookCountByAuthor(): Observable<AuthorStat[]> {
    return this.http.get<AuthorStat[]>(`${this.rootUrl}stats/book-count`);
  }


  public getTotalBookCount(): Observable<number> {
    return this.http.get<number>(`${this.rootUrl}stats/total-books`);
  }


  public getTotalAuthorCount(): Observable<number> {
    return this.http.get<number>('http://localhost:8082/stats/total-authors');
  }





}
