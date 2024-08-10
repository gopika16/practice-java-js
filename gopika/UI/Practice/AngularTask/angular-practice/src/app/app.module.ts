import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ColorDirective } from './custom-directive/color.directive';
import { MakeTradeComponent } from './Components/make-trade/make-trade.component';
import { CustomIfDirective } from './custom-directive/custom-if.directive';
import { PracticeDirectivesComponent } from './Components/practice-directives/practice-directives.component';
import { TemplateDrivenFormsComponent } from './Components/template-driven-forms/template-driven-forms.component';
import { BuySellComponent } from './Components/buy-sell/buy-sell.component';
import { StockQuantityComponent } from './Components/stock-quantity/stock-quantity.component';
import { PracticeObservablesComponent } from './Components/practice-observables/practice-observables.component';
import { LifeCycleComponent } from './Components/life-cycle/life-cycle.component';
import { ApiTaskComponent } from './Components/api-task/api-task.component';
import { AgGridModule } from 'ag-grid-angular';
import { GridExerciseComponent } from './Components/grid-exercise/grid-exercise.component';
import { HomeComponent } from './Components/home/home.component';
import { ShowErrorComponent } from './Components/show-error/show-error.component';
import { FarmerComponent } from './Components/farmer/farmer.component';

@NgModule({
  declarations: [
    AppComponent,
    TemplateDrivenFormsComponent,
    PracticeDirectivesComponent,
    ColorDirective,
    MakeTradeComponent,
    CustomIfDirective,
    BuySellComponent,
    StockQuantityComponent,
    PracticeObservablesComponent,
    LifeCycleComponent,
    ApiTaskComponent,
    GridExerciseComponent,
    HomeComponent,
    ShowErrorComponent,
    FarmerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AgGridModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
