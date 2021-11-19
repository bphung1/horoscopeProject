import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HoroscopeRoutingModule } from './horoscope-routing.module';
import { HoroscopepageComponent } from './horoscopepage/horoscopepage.component';


@NgModule({
  imports: [
    CommonModule,
    HoroscopeRoutingModule
  ],
  declarations: [
    HoroscopepageComponent
  ],
})
export class HoroscopeModule { }
