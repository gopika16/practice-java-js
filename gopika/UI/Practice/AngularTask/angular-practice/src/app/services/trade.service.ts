import { ITrade } from './../models/trade';
import { Injectable } from '@angular/core';
import { API, TRADE_ACTION, TRADE_MESSAGES } from '../constants/constants';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClientService } from '../Core/Http-client.service';

@Injectable({
  providedIn: 'root',
})
export class TradeService {
  constructor(private _httpClientService: HttpClientService) {}

  getTrade<ITrade>(): Observable<ITrade> {
    return this._httpClientService.get<ITrade>(API.MockApi);
  }

  tradeMessage(trade: ITrade): string {
    let message = TRADE_MESSAGES.UnSuccessful;
    if (trade.action === TRADE_ACTION.BUY) {
      message = TRADE_MESSAGES.BuySuccess;
    } else if (trade.action === TRADE_ACTION.SELL) {
      message = TRADE_MESSAGES.SellSuccess;
    }
    return message;
  }
}
