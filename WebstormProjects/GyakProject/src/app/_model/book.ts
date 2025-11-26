import {Author} from './author';

export class Book {
  isbn!:string;
  title!:string;
  publisher!:string;
  price!:number;
  pageNumber!:number;
  genre!:string;
  author!:Author;
}
