import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Subscription } from 'rxjs/internal/Subscription';

@Component({
  selector: 'app-practice-observables',
  templateUrl: './practice-observables.component.html',
  styleUrls: ['./practice-observables.component.css'],
})
export class PracticeObservablesComponent implements OnInit {
  private observable!: Observable<string>;
  subscription: Subscription;
  constructor() {
    this.subscription = new Subscription();
  }
  invokeObservable() {
    this.observable = new Observable((observer) => {
      observer.next('first');
      observer.next('second');
      observer.complete();
    });
    this.subscription = this.observable.subscribe({
      next: (value) => alert(value),
      error: (error) => console.log(error),
      complete: () => console.log('Complete'),
    });
  }
  OnDestroy() {
    this.subscription.unsubscribe();
  }

  ngOnInit(): void {
  }
}
