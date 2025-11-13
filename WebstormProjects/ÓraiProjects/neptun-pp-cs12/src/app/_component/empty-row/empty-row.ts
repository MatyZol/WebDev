import {Component, Input} from '@angular/core';

@Component({
  selector: 'tr[empty]', // ezzel a hivatkozással lehet beűágyazni ezt a copnentet aegy másikba // bizonyos nevű elemként akarjuk beszúrni akkor egy attribútummal kell cslezni
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
