import { TestBed } from '@angular/core/testing';

import { StudentClient } from './student-client';

describe('StudentClient', () => {
  let service: StudentClient;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudentClient);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
