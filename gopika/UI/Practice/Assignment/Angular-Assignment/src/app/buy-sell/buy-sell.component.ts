import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-buy-sell',
  templateUrl: './buy-sell.component.html',
  styleUrls: ['./buy-sell.component.css'],
})
export class BuySellComponent implements OnInit {
  submit() {
    throw new Error('Method not implemented.');
  }
  selectedOption: any;

  constructor() {}

  ngOnInit(): void {}
}
