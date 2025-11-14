import {Author} from './author';

export class Book {
  isbn!:string;
  title!:string;
  publisher!:string;
  price!:string;
  author!:Author;
}
