import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { User } from 'src/app/model/user';
import { AccountService } from '../account-service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  account$: Observable<User>;
  user: User;
  birthday: string;
  submitted = false;

  @ViewChild('f', { static: false }) signupForm: NgForm;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: AccountService
    ) { }

  ngOnInit(): void {
    this.account$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) =>
      this.service.userFromAPI)
    );
    this.account$.subscribe(data => this.user = data);
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }

  goToCreateNewUser() {
    this.router.navigate(['/new-user']);
  }

  generateHoroscope() {
    if (this.user) {
      this.router.navigate(['/horoscope', this.user.username]);
    } else {
      this.service.birthdayIfAnonymous = this.signupForm.value.userData.birthday;
      this.router.navigate(['/horoscope']);
    }
  }

  onSubmit() {
    console.log("Hello world");
  }

  logout(){
    this.service.getAccount('Anonymous', '0000');
    this.router.navigate(['homepage']);
  }

  setCorrectDateFormat() {
    let d = new Date(this.user.birthday),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    this.birthday = [month, day, year].join('-');
  }
}
