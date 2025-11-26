import { TestBed } from '@angular/core/testing';

import { StatClient } from './stat-client';

describe('StatClient', () => {
  let service: StatClient;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StatClient);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
