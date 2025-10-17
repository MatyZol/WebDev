import { TestBed } from '@angular/core/testing';

import { AuthorClient } from './author-client';

describe('AuthorClient', () => {
  let service: AuthorClient;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthorClient);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
