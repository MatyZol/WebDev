import { TestBed } from '@angular/core/testing';

import { BookClient } from './book-client';

describe('BookClient', () => {
  let service: BookClient;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookClient);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
