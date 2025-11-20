import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmptyRow } from './empty-row';

describe('EmptyRow', () => {
  let component: EmptyRow;
  let fixture: ComponentFixture<EmptyRow>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmptyRow]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmptyRow);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
