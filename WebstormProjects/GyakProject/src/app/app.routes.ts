import { Routes } from '@angular/router';

import {BookListComponent} from './_component/book-list-component/book-list-component';
import {AuthorListComponent} from './_component/author-list-component/author-list-component';


export const routes: Routes = [
  {path:'books',component:BookListComponent},
  {path:'authors',component:AuthorListComponent}
];
