import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AccountService } from 'src/app/home/account-service';
import { User } from 'src/app/model/user';


@Component({
  selector: 'app-new-userpage',
  templateUrl: './new-userpage.component.html',
  styleUrls: ['./new-userpage.component.css']
})
export class NewUserpageComponent implements OnInit {
  submitted = false;
  testUser: User;

  @ViewChild('f', { static: false }) signupForm: NgForm;

  constructor(private router : Router, private service : AccountService) { }




  ngOnInit(): void {
  }

  addNewUser() {
      let userInputUsername = this.signupForm.value.userData.username;
      let userInputPassword = this.signupForm.value.userData.password;
      let userInputName = this.signupForm.value.userData.name;
      let userInputBirthday = this.signupForm.value.userData.birthday;

      this.service.postNewAccount(userInputUsername, userInputPassword, userInputName, userInputBirthday);
//       this.service.getAccount(userInputUsername,userInputPassword);



      this.router.navigate(['/profile', userInputUsername]);
    }

}


