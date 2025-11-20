import { Pipe, PipeTransform } from '@angular/core';
import {Student} from '../_model/student';

@Pipe({
  name: 'student'
})
export class StudentPipe implements PipeTransform {

  transform(students: Student[],searchTerm: string, orderBy: keyof Student, desc: boolean): Student[] {
    return students
      ?.filter(student => !searchTerm // ?. -> lustakiértékelés -> igaz-e az értéke a kifejezésnek -> a igen akkor kiértékeljük, ha nem akkor nem fut le a mögötte lévő kód
      || student.name.toLowerCase().includes(searchTerm.toLowerCase())
      || student.neptun.toLowerCase().includes(searchTerm.toLowerCase()))
      ?.sort((a,b)=> {
        if(!orderBy || a[orderBy] == b[orderBy]){
          return 0;
        }
        return (a[orderBy] < b[orderBy]? -1 : 1)
                  *(desc ? -1 : 1);
      });
  }

}
