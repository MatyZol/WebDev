import { Pipe, PipeTransform } from '@angular/core';
import {Book} from '../_model/book';
import {Author} from '../_model/author';

@Pipe({
  name: 'author'
})
export class AuthorPipe implements PipeTransform {

  transform(authors: Author[],searchTerm: string): Author[] {
    return authors
      ?.filter(author => !searchTerm
        || author.lastName.toLowerCase().includes(searchTerm.toLowerCase())
        || author.firstName.toLowerCase().includes(searchTerm.toLowerCase()));
  }
}
