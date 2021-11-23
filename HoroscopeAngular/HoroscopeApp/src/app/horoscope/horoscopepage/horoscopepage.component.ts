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

  predictions = PREDICTIONS; //replace PREDICTIONS with api call for all prediction
  prediction: Prediction;
  selectedHoroscopeDate: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: AccountService
    ) { }

  ngOnInit(): void {
    this.getRandomHoroscope();
    this.setCorrectDateFormat();
    this.account$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) =>
      this.service.getAccount(params.get('username')!))
    );
    this.account$.subscribe(data => this.user = data);
  }

  goToProfile() {
    this.router.navigate(['profile', this.user.username]);
  }

  setCorrectDateFormat() {
    let d = new Date(this.prediction.timestamp),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    this.selectedHoroscopeDate = [month, day, year].join('-');
  }

  getRandomHoroscope() {
    let random = this.getRandomNumber(this.predictions.length);
    this.prediction = this.predictions[random];
  }

  savePredictions() {
    console.log('call api to save');
  }

  private getRandomNumber(bound: number) {
    return Math.floor(Math.random() * bound);
  }
}
