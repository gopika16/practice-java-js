import {
  AfterContentChecked,
  AfterContentInit,
  AfterViewChecked,
  AfterViewInit,
  Component,
  DoCheck,
  OnChanges,
  OnDestroy,
  OnInit,
  SimpleChanges,
} from '@angular/core';

@Component({
  selector: 'app-life-cycle',
  templateUrl: './life-cycle.component.html',
  styleUrls: ['./life-cycle.component.css'],
})
export class LifeCycleComponent
  implements
    OnInit,
    OnChanges,
    OnDestroy,
    DoCheck,
    AfterContentInit,
    AfterContentChecked,
    AfterViewChecked,
    AfterViewInit
{
  value: Boolean;
  iterator = 1;
  submit() {
    console.log('submitted');
  }
  constructor() {
    this.value = true;
    console.log('constructor');
  }
  ngOnChanges(changes: SimpleChanges): void {
    console.log('on changes');
  }
  ngOnDestroy(): void {
    console.log('on Destroy life cycle');
  }
  ngDoCheck(): void {
    // this is when to destroy api task component
    this.iterator++;
    if (this.iterator == 5) {
      this.value = false;
    }
    console.log('on do check');
  }
  ngAfterContentInit(): void {
    console.log('on after content init');
  }
  ngAfterContentChecked(): void {
    console.log('on after content checked');
  }
  ngAfterViewChecked(): void {
    console.log('on after view checked');
  }
  ngAfterViewInit(): void {
    console.log('on after view init');
  }
  ngOnInit(): void {
    console.log('on init');
  }
}
