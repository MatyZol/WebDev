import {Component, OnInit} from '@angular/core';
import {BookClient} from '../../_service/book-client';
import {Book} from '../../_model/book';
import {JsonPipe} from '@angular/common';
import {iterator} from 'rxjs/internal/symbol/iterator';

@Component({
  selector: 'app-book-list-component',
  imports: [
    JsonPipe
  ],
  templateUrl: './book-list-component.html',
  styleUrl: './book-list-component.scss'
})
export class BookListComponent implements OnInit {

  protected books!: Book[];

  constructor(private client:BookClient) {
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

  protected delete(isbn:string):void {
    this.client.delete(isbn).subscribe(
      response => {
        this.ngOnInit()
      }
    )
  }



}
