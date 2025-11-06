import { Routes } from '@angular/router';
import {StudentListComponent} from './_component/student-list-component/student-list-component';
import {StudentEditComponent} from './_component/student-edit-component/student-edit-component';
import {SubjectListComponent} from './_component/subject-list-component/subject-list-component';

export const routes: Routes = [
  {path:'student',component:StudentListComponent},
  {path:'student/:neptun',component:StudentEditComponent},
  {path:'subject',component:SubjectListComponent},
  {path:'**',redirectTo:'student'},

];
