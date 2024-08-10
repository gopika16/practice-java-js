import { ITrade } from '../../models/trade';
import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnDestroy,
  Output,
  SimpleChanges,
} from '@angular/core';

@Component({
  selector: 'app-buy-sell',
  templateUrl: './buy-sell.component.html',
  styleUrls: ['./buy-sell.component.css'],
})
export class BuySellComponent implements OnChanges,OnDestroy {
  @Input() trade: ITrade;
  @Output() UpdateSecuritySymbol = new EventEmitter();
  constructor() {
    this.trade = {
      action: null,
    } as ITrade;
  }
  ngOnDestroy(): void {
    alert("OnDestroy");
  }

  emitSymbol(symbol: string): void {
    this.UpdateSecuritySymbol.emit(symbol);
  }

  ngOnChanges(changes: SimpleChanges) {}

  ngOnInit(): void {}
}
