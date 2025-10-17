import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BookClient} from '../../_service/book-client';
import {Book} from '../../_model/book';

@Component({
  selector: 'app-book-component',
  imports: [],
  templateUrl: './book-component.html',
  styleUrl: './book-component.scss'
})
export class BookComponent implements OnInit {

  book!: Book;


  constructor(private client:BookClient) {
  }

  ngOnInit(): void {
    this.client.getOne().subscribe({
      next:response=> { this.book = response; },
      }
    )
  }


}
