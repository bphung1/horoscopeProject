import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

import { Prediction } from 'src/app/model/prediction';
import { PREDICTIONS } from 'src/app/model/predictionTempData';

@Component({
  selector: 'app-profilepage',
  templateUrl: './profilepage.component.html',
  styleUrls: ['./profilepage.component.css']
})
export class ProfilepageComponent implements OnInit {
  predictions = PREDICTIONS;
  prediction: Prediction;
  username = 'JMoney69420';
  name = 'Jon';
  birthday = new Date(500000000000);  

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  updateUser() {
      console.log("update user")
    }

  goToHomePage() {
    this.router.navigate(['homepage']);
  }

}
