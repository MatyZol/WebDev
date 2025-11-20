import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortableTh } from './sortable-th';

describe('SortableTh', () => {
  let component: SortableTh;
  let fixture: ComponentFixture<SortableTh>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SortableTh]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SortableTh);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
