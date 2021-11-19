import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HoroscopepageComponent } from '../horoscope/horoscopepage/horoscopepage.component';

const routes: Routes = [
  { path: 'horoscope', component: HoroscopepageComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfileRoutingModule { }
