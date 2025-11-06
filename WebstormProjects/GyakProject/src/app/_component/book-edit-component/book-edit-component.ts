import {Component, OnInit} from '@angular/core';
import {Book} from '../../_model/book';
import {BookClient} from '../../_service/book-client';
import {ActivatedRoute, convertToParamMap} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {JsonPipe} from '@angular/common';


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
  protected param!: string | null;
  constructor(
    private client:BookClient,
    private route:ActivatedRoute
  ) {
  }


  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>
    {
      this.param=params.get('isbn');
      if(params.get('isbn') == 'create'){
        this.book = {} as Book;

      }
      else {
        this.client.getOne(params.get('isbn')!).subscribe(book => {
          this.book = book;
        })
      }
    })
  }

  protected create(): void{
    this.client.create(this.book).subscribe( {
      next: book =>{
        this.book = book;
        alert("Könyv sikeresen létrehozva");
      },error: err => {
        alert(JSON.stringify(err.m))
      }
    })
  }

  protected update(): void {
    this.client.update(this.book).subscribe({
      next: book => {
        this.book = book;
        alert("Könyv sikeresen modosítva");
      }, error: err => {
        alert(JSON.stringify(err.m))
      }
    })
  }
}
