import {Component, OnInit} from '@angular/core';
import {Book} from '../../_model/book';
import {BookClient} from '../../_service/book-client';
import {ActivatedRoute, convertToParamMap, Router} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {DatePipe, JsonPipe} from '@angular/common';
import {Author} from '../../_model/author';
import {AuthorClient} from '../../_service/author-client';


@Component({
  selector: 'app-book-edit-component',
  imports: [
    FormsModule,
    JsonPipe
  ],
  templateUrl: './book-edit-component.html',
  styleUrl: './book-edit-component.scss'
})
export class BookEditComponent implements OnInit{

  protected book!: Book;
  protected author!: Author;
  protected param!: string | null;
  protected authors!: Author[];
  constructor(
    private bookClient:BookClient,
    private route:ActivatedRoute,
    private router:Router,
    private authorClient:AuthorClient
  ) {
  }

  protected compareAuthors(author1: Author, author2: Author): boolean {
    
    return author1 && author2 ? author1.authorID === author2.authorID : author1 === author2;
  }


  ngOnInit(): void {

    this.authorClient.findAll().subscribe( authors => {
      this.authors = authors;
    })

    this.route.paramMap.subscribe(params =>
    {
      this.param=params.get('isbn');
      if(params.get('isbn') == 'create'){
        this.book = {} as Book;
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
        this.router.navigate(['books',book.isbn]);
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
