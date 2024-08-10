import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appCustomIf]',
})
export class CustomIfDirective {
  @Input()
  set appCustomIf(showElement: boolean) {
    showElement
      ? this.container.createEmbeddedView(this.templateRef)
      : this.container.clear();
  }
  constructor(
    private templateRef: TemplateRef<any>,
    private container: ViewContainerRef
  ) {}
}
