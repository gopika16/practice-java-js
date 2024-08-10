import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PracticeObservablesComponent } from './practice-observables.component';

describe('PracticeObservablesComponent', () => {
  let component: PracticeObservablesComponent;
  let fixture: ComponentFixture<PracticeObservablesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PracticeObservablesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PracticeObservablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
