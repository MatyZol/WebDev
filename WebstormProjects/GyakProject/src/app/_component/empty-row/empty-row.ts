import {Component, Input} from '@angular/core';

@Component({
  selector: 'tr[empty]',
  imports: [],
  templateUrl: './empty-row.html',
  styleUrl: './empty-row.scss'
})
export class EmptyRow {
  @Input()
  public colSpan!:number;
  @Input()
  public entity!:string;
}
