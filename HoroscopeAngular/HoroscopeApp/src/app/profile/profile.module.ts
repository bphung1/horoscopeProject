import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfilepageComponent } from './profilepage/profilepage.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [ProfilepageComponent],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class ProfileModule { }
