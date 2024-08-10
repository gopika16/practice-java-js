import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockQuantityComponent } from './stock-quantity.component';

describe('StockQuantityComponent', () => {
  let component: StockQuantityComponent;
  let fixture: ComponentFixture<StockQuantityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StockQuantityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StockQuantityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
