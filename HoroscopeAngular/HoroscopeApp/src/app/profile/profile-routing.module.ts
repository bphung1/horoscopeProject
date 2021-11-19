import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HoroscopepageComponent } from '../horoscope/horoscopepage/horoscopepage.component';
import { ProfilepageComponent } from './profilepage/profilepage.component';

const routes: Routes = [
  // { path: 'profile', component: ProfilepageComponent},
  { path: 'horoscope', component: HoroscopepageComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfileRoutingModule { }
