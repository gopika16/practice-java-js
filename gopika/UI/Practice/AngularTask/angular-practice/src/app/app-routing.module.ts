
import { PracticeObservablesComponent } from './Components/practice-observables/practice-observables.component';
import { MakeTradeComponent } from './Components/make-trade/make-trade.component';
import { GridExerciseComponent } from './Components/grid-exercise/grid-exercise.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LifeCycleComponent } from './Components/life-cycle/life-cycle.component';
import { HomeComponent } from './Components/home/home.component';
import { ShowErrorComponent } from './Components/show-error/show-error.component';

const routes: Routes = [
  { path: 'trade', component: MakeTradeComponent },
  { path: 'grid', component: GridExerciseComponent },
  { path: 'observables', component: PracticeObservablesComponent },
  { path: 'lifecycle', component: LifeCycleComponent },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', component: ShowErrorComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
