import {Book} from './book';

export class Author {
  authorID!:number;
  firstName!:string;
  lastName!:string;
  dateOfBirth!:string;
  books!:Book[];
}
