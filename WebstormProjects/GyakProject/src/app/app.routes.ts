import { Routes } from '@angular/router';

import {BookListComponent} from './_component/book-list-component/book-list-component';
import {AuthorListComponent} from './_component/author-list-component/author-list-component';
import {BookEditComponent} from './_component/book-edit-component/book-edit-component';


export const routes: Routes = [
  {path:'books',component:BookListComponent},
  {path:'authors',component:AuthorListComponent},
  {path:'books/:isbn',component:BookEditComponent},
];
