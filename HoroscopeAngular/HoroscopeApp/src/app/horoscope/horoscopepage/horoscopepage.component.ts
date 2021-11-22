import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PREDICTIONS } from 'src/app/model/predictionTempData';
import { Prediction } from 'src/app/model/prediction';

@Component({
  selector: 'app-horoscopepage',
  templateUrl: './horoscopepage.component.html',
  styleUrls: ['./horoscopepage.component.css']
})
export class HoroscopepageComponent implements OnInit {
  predictions = PREDICTIONS;
  prediction: Prediction;
  selectedHoroscopeDate: string;

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.getRandomHoroscope();
    this.setCorrectDateFormat();
  }

  goToProfile() {
    this.router.navigate(['profile']);
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

  private getRandomNumber(bound: number) {
    return Math.floor(Math.random() * bound);
  }
}
