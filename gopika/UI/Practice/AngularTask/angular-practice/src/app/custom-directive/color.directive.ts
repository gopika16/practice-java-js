import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appColor]',
})
export class ColorDirective {
  @Input('appColor') colors: string | undefined;
  @Input() defaultColor: string = '';

  @HostListener('mouseenter') onMouseEnter() {
    this.setBackgroundColor(this.colors || this.defaultColor);
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.setBackgroundColor('');
  }

  constructor(private elementReference: ElementRef) {}

  private setBackgroundColor(color: string): void {
    this.elementReference.nativeElement.style.backgroundColor = color;
  }
}
