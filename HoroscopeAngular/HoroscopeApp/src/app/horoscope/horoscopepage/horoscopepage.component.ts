import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { PREDICTIONS } from 'src/app/model/predictionTempData';
import { Prediction } from 'src/app/model/prediction';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user';
import { AccountService } from 'src/app/home/account-service';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-horoscopepage',
  templateUrl: './horoscopepage.component.html',
  styleUrls: ['./horoscopepage.component.css']
})
export class HoroscopepageComponent implements OnInit {
  account$: Observable<User>;
  user: User;

  prediction$: Observable<Prediction>;
  prediction: Prediction;
  selectedHoroscopeDate: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: AccountService
    ) { }

  ngOnInit(): void {
    if (!this.service.userFromAPI) {
      this.service.getAccount('Anonymous', '0000');
    }

    this.account$ = this.service.userFromAPI;
    this.account$.subscribe(data => {
      this.user = data;
      if (data.birthday === '0001-01-01') {
        this.user.birthday = this.service.birthdayIfAnonymous;
      }
      console.log(this.user);

      this.prediction$ = this.service.getHoroscope(this.user.username, this.user.birthday);
      this.prediction$.subscribe(dt => {
        this.prediction = dt;
        console.log(dt);
      })
    });

  }

  goToProfile() {
    this.router.navigate(['profile', this.user.username]);
  }

  goToHome() {
      this.router.navigate(['homepage']);
    }


}
