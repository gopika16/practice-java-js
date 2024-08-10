import { Component, Input, OnInit, OnDestroy } from '@angular/core';
import { ITrade } from 'src/app/models/trade';

@Component({
  selector: 'app-stock-quantity',
  templateUrl: './stock-quantity.component.html',
  styleUrls: ['./stock-quantity.component.css'],
})
export class StockQuantityComponent implements OnInit {
  @Input() trade: ITrade;
  quantity: number;
  constructor() {
    this.quantity = 0;
    this.trade = {
      action: null,
    } as ITrade;
  }
  ngOnInit(): void {}
  showTradeSymbol(symbol: string) {
    console.log(`your selected symbol is : ${symbol} `);
  }
}
