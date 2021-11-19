import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HoroscopepageComponent } from '../horoscope/horoscopepage/horoscopepage.component';
import { LoginpageComponent } from '../login/loginpage/loginpage.component';
import { NewUserpageComponent } from '../new-user/new-userpage/new-userpage.component';
import { ProfilepageComponent } from '../profile/profilepage/profilepage.component';
import { HomepageComponent } from './homepage/homepage.component';

const routes: Routes = [
  // { path: 'homepage', component: HomepageComponent},
  // { path: 'login', component: LoginpageComponent},
  // { path: 'horoscope', component: HoroscopepageComponent},
  // { path: 'new-user', component: NewUserpageComponent},
  // { path: 'profile', component: ProfilepageComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
