import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Student} from '../../_model/student';

@Component({
  selector: 'th[sortable-v2]',
  imports: [],
  templateUrl: './sortable-th-v2.html',
  styleUrl: './sortable-th-v2.scss'
})
export class SortableThV2 {
  @Input()
  value!: keyof Student;
  @Input()
  orderBy!: keyof Student;
  @Input()
  desc!: boolean;

  @Output()
  orderByChange: EventEmitter<keyof Student> = new EventEmitter();

  @Output()
  descChange: EventEmitter<boolean> = new EventEmitter();

  protected click():void{
    if(this.value == this.orderBy){
      this.descChange.emit(!this.desc); // létrehozzuk azt az eseményt amire a másik componens fel tud iratkozni

    } else {
      this.descChange.emit(false);
      this.orderByChange.emit(this.value);
    }
  }
}
