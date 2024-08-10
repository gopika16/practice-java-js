import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormTeComponent } from './form-te.component';

describe('FormTeComponent', () => {
  let component: FormTeComponent;
  let fixture: ComponentFixture<FormTeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormTeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormTeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
