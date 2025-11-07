import {Component, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {JsonPipe} from "@angular/common";
import {AuthorClient} from '../../_service/author-client';
import {Author} from '../../_model/author';
import {Book} from '../../_model/book';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-author-edit-component',
    imports: [
        FormsModule,
        JsonPipe
    ],
  templateUrl: './author-edit-component.html',
  styleUrl: './author-edit-component.scss'
})
export class AuthorEditComponent implements OnInit {


  protected author!: Author;
  protected param!: string | null;
constructor(private authorClient: AuthorClient,
            private route:ActivatedRoute,
            private router:Router) {
}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>
    {
      this.param=params.get('authorID');
      if(params.get('authorID') == 'create'){
        this.author = {} as Author;
      }
      else {
        this.authorClient.getOne(Number(params.get('authorID')!)).subscribe(author => {
          this.author = author;
        })
      }
    })
  }



  public createAuthor(): void {
    this.authorClient.create(this.author).subscribe( {
      next:author =>{

        this.author = author;
        this.router.navigate(['authors',author.authorID.toString()]);
        alert("Szerző sikeresen létrehozva");
      },error: err => {
        alert(JSON.stringify(err))
      }
    })
  }

  public update(): void {
    this.authorClient.update(this.author).subscribe({
      next: author => {
        this.author = author;
        alert("Szerző sikeresen modosítva");
      }, error: err => {
        alert(JSON.stringify(err.m))
      }
    })
  }


}


