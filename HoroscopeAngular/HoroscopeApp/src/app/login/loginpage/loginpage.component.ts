import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { USERS } from 'src/app/model/userTempData';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {
  users = USERS; //will delete after implementing API
  user: User;

  submitted = false;

  @ViewChild('f', { static: false }) signupForm: NgForm;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    let userInputUsername = this.signupForm.value.userData.username;
    let userInputPassword = this.signupForm.value.userData.password;

    this.user = this.users.find(acct => {
      return acct.username === userInputUsername && acct.password === userInputPassword;
    })

    if (!this.user) {
      this.signupForm.reset();
      alert('Incorrect User/Password');
    } else {
      this.router.navigate(['profile', this.user.username]);
    }

  }

}
