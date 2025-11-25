import {Component, OnInit} from '@angular/core';
import {BookClient} from '../../_service/book-client';
import {Book} from '../../_model/book';
import {JsonPipe} from '@angular/common';
import {iterator} from 'rxjs/internal/symbol/iterator';
import {RouterLink} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {BookPipe} from '../../_pipe/book-pipe';
import {EmptyRow} from '../empty-row/empty-row';
import {AuthService} from '../../_service/auth-service';

@Component({
  selector: 'app-book-list-component',
  imports: [

    RouterLink,
    FormsModule,
    BookPipe,
    EmptyRow
  ],
  templateUrl: './book-list-component.html',
  styleUrl: './book-list-component.scss'
})
export class BookListComponent implements OnInit {

  protected books!: Book[];
  protected searchTerm!: string;

  constructor(private client:BookClient,private auth: AuthService) {
  }



  ngOnInit(): void {
    this.client.findAll().subscribe(
      {
        next: response => {
          this.books = response;
        }
      }
    )
  }

  onLogout(){
    this.auth.logout();
  }

  protected delete(isbn:string):void {
    this.client.delete(isbn).subscribe(
      response => {
        this.ngOnInit()
      }
    )
  }



}
