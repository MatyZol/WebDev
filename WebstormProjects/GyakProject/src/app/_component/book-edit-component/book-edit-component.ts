import {Component, OnInit} from '@angular/core';
import {Book} from '../../_model/book';
import {BookClient} from '../../_service/book-client';
import {ActivatedRoute, convertToParamMap} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {DatePipe, JsonPipe} from '@angular/common';
import {Author} from '../../_model/author';
import {AuthorClient} from '../../_service/author-client';


@Component({
  selector: 'app-book-edit-component',
  imports: [
    FormsModule,
    JsonPipe,
    DatePipe
  ],
  templateUrl: './book-edit-component.html',
  styleUrl: './book-edit-component.scss'
})
export class BookEditComponent implements OnInit{

  protected book!: Book;
  protected author!: Author;
  protected param!: string | null;
  constructor(
    private bookClient:BookClient,
    private authorClient:AuthorClient,
    private route:ActivatedRoute
  ) {
  }


  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>
    {
      this.param=params.get('isbn');
      if(params.get('isbn') == 'create'){
        this.book = {} as Book;
        this.author = {} as Author;
      }
      else {
        this.bookClient.getOne(params.get('isbn')!).subscribe(book => {
          this.book = book;
        })
      }
    })
  }

  protected createBook(): void{
    this.bookClient.create(this.book).subscribe( {
      next: book =>{
        this.book = book;
        alert("Könyv sikeresen létrehozva");
      },error: err => {
        alert(JSON.stringify(err))
      }
    })
  }

  protected createAuthor(): void {
    this.authorClient.create(this.author).subscribe( {
      next:author =>{

        this.author = author;
        alert("Szerző sikeresen létrehozva");
      },error: err => {
        alert(JSON.stringify(err))
      }
    })
  }

  protected update(): void {
    this.bookClient.update(this.book).subscribe({
      next: book => {
        this.book = book;
        alert("Könyv sikeresen modosítva");
      }, error: err => {
        alert(JSON.stringify(err.m))
      }
    })
  }
}
