import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MakeTradeComponent } from './make-trade.component';

describe('MakeTradeComponent', () => {
  let component: MakeTradeComponent;
  let fixture: ComponentFixture<MakeTradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MakeTradeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeTradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
