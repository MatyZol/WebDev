import {Component, OnInit} from '@angular/core';
import {Book} from '../../_model/book';
import {Author} from '../../_model/author';

import {BookClient} from '../../_service/book-client';
import {AuthorClient} from '../../_service/author-client';
import {FormsModule} from '@angular/forms';
import {JsonPipe} from '@angular/common';
import {BookAuthorClient} from '../../_service/book-author-client';

@Component({
  selector: 'app-book-author-edit-component',
  imports: [
    FormsModule,
    JsonPipe

  ],
  templateUrl: './book-author-edit-component.html',
  styleUrl: './book-author-edit-component.scss'
})
export class BookAuthorEditComponent implements OnInit {

  books!:Book[];
  authors!:Author[];
  book!:Book;

  selectedAuthor!: Author;
  constructor(private bookClient : BookClient,
              private authorClient : AuthorClient,
              private bookAuthorClient : BookAuthorClient) {
  }

  ngOnInit(): void {

    this.book = {} as Book;

    this.bookClient.findAll().subscribe({
      next: response =>
      this.books = response
    })

    this.authorClient.findAll().subscribe({
      next: response =>
        this.authors = response
    })

  }

  connectBookAuthor():void{
    this.book.author = this.selectedAuthor;
    this.bookAuthorClient.connect(this.book).subscribe({
      next: book => {
        this.book = book;
        alert("Sikeres")
      },error: error => {
        alert(JSON.stringify(error))
      }
    })
  }



}
