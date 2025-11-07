import {Component, OnInit} from '@angular/core';
import {AuthorClient} from '../../_service/author-client';
import {Author} from '../../_model/author';
import {JsonPipe} from '@angular/common';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-author-list-component',
  imports: [
    JsonPipe,
    RouterLink
  ],
  templateUrl: './author-list-component.html',
  styleUrl: './author-list-component.scss'
})
export class AuthorListComponent implements OnInit {

  protected authors!: Author[];

  constructor(private client:AuthorClient) {
  }

  ngOnInit(): void {
    this.client.findAll().subscribe({
      next:response => {this.authors = response}
    })

  }

  protected delete(authorID:number):void{
    this.client.delete(authorID).subscribe(response=> {
      this.ngOnInit()
    })
  }

}
