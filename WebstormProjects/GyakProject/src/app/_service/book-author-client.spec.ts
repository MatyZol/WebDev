import { TestBed } from '@angular/core/testing';

import { BookAuthorClient } from './book-author-client';

describe('BookAuthorClient', () => {
  let service: BookAuthorClient;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookAuthorClient);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
