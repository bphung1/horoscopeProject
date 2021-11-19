import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomepageComponent } from './home/homepage/homepage.component';
import { HoroscopepageComponent } from './horoscope/horoscopepage/horoscopepage.component';
import { LoginpageComponent } from './login/loginpage/loginpage.component';

const routes: Routes = [
  { path: 'homepage', component: HomepageComponent},
  { path: '', component: HomepageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
