import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NewUserRoutingModule } from './new-user-routing.module';
import { NewUserpageComponent } from './new-userpage/new-userpage.component';


@NgModule({
  declarations: [NewUserpageComponent],
  imports: [
    CommonModule,
    NewUserRoutingModule
  ]
})
export class NewUserModule { }
