import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NewUserpageComponent } from './new-userpage/new-userpage.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [NewUserpageComponent],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class NewUserModule { }
