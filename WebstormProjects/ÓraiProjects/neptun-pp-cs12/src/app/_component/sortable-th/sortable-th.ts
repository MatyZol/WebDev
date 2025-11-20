import {Component, Input} from '@angular/core';
import {Student} from '../../_model/student';

@Component({
  selector: 'th[sortable]',
  imports: [],
  templateUrl: './sortable-th.html',
  styleUrl: './sortable-th.scss'
})
export class SortableTh {

    @Input()
    value!: keyof Student;
    @Input()
    orderBy!: keyof Student;
    @Input()
    desc!:boolean;
    @Input()
    order!: (value: keyof Student) => void;
}
