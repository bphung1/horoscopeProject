import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomepageComponent } from './homepage/homepage.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [HomepageComponent],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class HomeModule { }
