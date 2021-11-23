import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AccountService } from 'src/app/home/account-service';
import { User } from 'src/app/model/user';
import { USERS } from 'src/app/model/userTempData';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {
  users = USERS; //will delete after implementing API
  user$: Observable<User>;
  user: User;

  submitted = false;

  @ViewChild('f', { static: false }) signupForm: NgForm;

  constructor(private router: Router, private service: AccountService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    let userInputUsername = this.signupForm.value.userData.username;
    let userInputPassword = this.signupForm.value.userData.password;

    this.user$ = this.service.getAccount(userInputUsername, userInputPassword);
    
    this.user$.subscribe(data => {
      this.user = data;

      if (!this.user) {
        this.signupForm.reset();
        alert('Incorrect User/Password');
      } else {
        this.router.navigate(['profile', this.user.username]);
      }
    });
  }

}
