import { Routes } from '@angular/router';

import {BookListComponent} from './_component/book-list-component/book-list-component';
import {AuthorListComponent} from './_component/author-list-component/author-list-component';
import {BookEditComponent} from './_component/book-edit-component/book-edit-component';
import {BookAuthorEditComponent} from './_component/book-author-edit-component/book-author-edit-component';
import {AuthorEditComponent} from './_component/author-edit-component/author-edit-component';
import {authGuard} from './_guards/auth-guard';
import {LoginComponent} from './_component/login-component/login-component';
import {RegisterComponent} from './_component/register-component/register-component';
import {StatisticsComponent} from './_component/statistics-component/statistics-component';


export const routes: Routes = [
  {path:'',redirectTo:'books',pathMatch:'full'},
  {path:'books',component:BookListComponent,canActivate:[authGuard]},
  {path:'authors',component:AuthorListComponent,canActivate:[authGuard]},
  {path:'books/:isbn',component:BookEditComponent,canActivate:[authGuard]},
  {path:'authors/:authorID',component:AuthorEditComponent,canActivate:[authGuard]},
  {path:'bookAuthor',component:BookAuthorEditComponent,canActivate:[authGuard]},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent },
  {path:'stats',component:StatisticsComponent,canActivate:[authGuard]}

];
