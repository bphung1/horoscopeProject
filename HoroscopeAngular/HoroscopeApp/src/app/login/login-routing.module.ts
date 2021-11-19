import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfilepageComponent } from '../profile/profilepage/profilepage.component';

const routes: Routes = [
  { path: 'profile', component: ProfilepageComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
