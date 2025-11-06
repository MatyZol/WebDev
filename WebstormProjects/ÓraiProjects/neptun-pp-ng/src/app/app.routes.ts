import {Routes} from '@angular/router';
import {StudentListComponent} from './_component/student-list-component/student-list-component';
import {StudentEditComponent} from './_component/student-edit-component/student-edit-component';

export const routes: Routes = [
  {path: 'student', component: StudentListComponent},
  {path: 'student/:neptun', component: StudentEditComponent},
  {path: '**', redirectTo: 'student'}
];
