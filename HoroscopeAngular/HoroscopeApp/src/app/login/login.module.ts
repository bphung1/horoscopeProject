import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginpageComponent } from './loginpage/loginpage.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [LoginpageComponent],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class LoginModule { }
