import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortableThV2 } from './sortable-th-v2';

describe('SortableThV2', () => {
  let component: SortableThV2;
  let fixture: ComponentFixture<SortableThV2>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SortableThV2]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SortableThV2);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
