import { StockQuantityComponent } from './../stock-quantity/stock-quantity.component';
import { TradeService } from '../../services/trade.service';
import {
  Component,
  OnChanges,
  SimpleChanges,
  ViewChild,
  OnDestroy,
} from '@angular/core';
import { ITrade } from '../../models/trade';
import { TRADE_MESSAGES } from '../../constants/constants';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-make-trade',
  templateUrl: './make-trade.component.html',
  styleUrls: ['./make-trade.component.css'],
})
export class MakeTradeComponent implements OnChanges, OnDestroy {
  @ViewChild('QuantityReference')
  stockQuantityComponent!: StockQuantityComponent;
  trade: ITrade;
  subscription: Subscription;
  // name: string;
  constructor(
    private _tradeService: TradeService,
    private _activatedRoute: ActivatedRoute
  ) {

    this.subscription = new Subscription();
    this.trade = {
      action: null,
    } as ITrade;
  }

  ngOnChanges(changes: SimpleChanges): void {}
  ngOnInit(): void {
    // this._activatedRoute.queryParams.subscribe((params) => {
    //   this.name = params['name'];
    // });
  }

  test() {
    this.stockQuantityComponent.showTradeSymbol(this.trade.symbol);
  }

  getTradeData(): void {
    // this.tradeService.getTrade().subscribe((data) => console.log(data));
    this.subscription = this._tradeService.getTrade().subscribe({
      next: (message) => {
        console.log(message);
      },
      error: (error) => {
        console.error(error);
      },
      complete: () => {
        console.info('Success');
      },
    });
  }

  submit(): void {
    const response = this._tradeService.tradeMessage(this.trade);
    const tradeMessage = this.generateTradeMessage(response);
    console.log('stock quantity : ' + this.stockQuantityComponent.quantity);
    this.stockQuantityComponent.showTradeSymbol(this.trade.symbol);
    alert(tradeMessage);
  }

  getResult(symbol: string) {
    this.trade.symbol = symbol;
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  private generateTradeMessage(response: string): string {
    const tradeMessage = `${TRADE_MESSAGES.AccountName} ${this.trade.account}
${TRADE_MESSAGES.Symbol}  ${this.trade.symbol}
${response}`;
    return tradeMessage;
  }
}
