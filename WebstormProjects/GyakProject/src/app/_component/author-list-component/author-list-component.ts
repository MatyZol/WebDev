import {Component, OnInit} from '@angular/core';
import {AuthorClient} from '../../_service/author-client';
import {Author} from '../../_model/author';
import {JsonPipe, NgIf} from '@angular/common';
import {RouterLink} from '@angular/router';
import {Book} from '../../_model/book';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AuthorPipe} from '../../_pipe/author-pipe';
import {EmptyRow} from '../empty-row/empty-row';
declare var bootstrap: any;

@Component({
  selector: 'app-author-list-component',
  imports: [

    RouterLink,
    NgIf,
    ReactiveFormsModule,
    FormsModule,
    AuthorPipe,
    EmptyRow
  ],
  templateUrl: './author-list-component.html',
  styleUrl: './author-list-component.scss'
})
export class AuthorListComponent implements OnInit {

  protected authors!: Author[];
  protected book!: Book;
  protected searchTerm!: string;
  constructor(private client:AuthorClient) {
  }

  ngOnInit(): void {
    this.client.findAll().subscribe({
      next:response => {this.authors = response}
    })

  }

  openModal() {
    const modalEl = document.getElementById('deleteModal');
    const modal = new bootstrap.Modal(modalEl);
    modal.show();
  }

  closeModal() {
    const modalEl = document.getElementById('deleteModal');
    const modal = new bootstrap.Modal(modalEl);
    modal.close();
  }

  protected delete(authorID:number):void{
    this.client.delete(authorID).subscribe({
      next: () => {
        this.ngOnInit();
      },
      error: (err) => {
        if(err.status === 409){
          this.openModal();
        }else{
          alert(JSON.stringify(err));
        }
      }
    });
  }

  // protected delete(authorID:number):void{
  //   this.client.delete(authorID).subscribe(response=> {
  //     this.ngOnInit()
  //   })
  // }

}
