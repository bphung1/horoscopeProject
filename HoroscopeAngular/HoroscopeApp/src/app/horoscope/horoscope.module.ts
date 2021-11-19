import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HoroscopeRoutingModule } from './horoscope-routing.module';
import { HoroscopepageComponent } from './horoscopepage/horoscopepage.component';
import { ProfileRoutingModule } from '../profile/profile-routing.module';


@NgModule({
  declarations: [HoroscopepageComponent],
  imports: [
    CommonModule,
    HoroscopeRoutingModule,
    ProfileRoutingModule
  ]
})
export class HoroscopeModule { }
