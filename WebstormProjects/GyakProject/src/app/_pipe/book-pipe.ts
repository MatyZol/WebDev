import { Pipe, PipeTransform } from '@angular/core';
import {Book} from '../_model/book';

@Pipe({
  name: 'book'
})
export class BookPipe implements PipeTransform {

  transform(books: Book[],searchTerm: string): Book[] {
    return books
      ?.filter(book => !searchTerm
        || book.title.toLowerCase().includes(searchTerm.toLowerCase())
        || book.isbn.toLowerCase().includes(searchTerm.toLowerCase()));
  }

}
