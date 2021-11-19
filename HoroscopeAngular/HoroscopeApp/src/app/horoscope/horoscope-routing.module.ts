import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfilepageComponent } from '../profile/profilepage/profilepage.component';
import { HoroscopepageComponent } from './horoscopepage/horoscopepage.component';

const routes: Routes = [
  { path: 'horoscope', component: HoroscopepageComponent},
  { path: 'profile', component: ProfilepageComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HoroscopeRoutingModule { }
