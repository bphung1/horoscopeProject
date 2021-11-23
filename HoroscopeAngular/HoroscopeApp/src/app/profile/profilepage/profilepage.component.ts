import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { NgForm } from '@angular/forms';

import { Prediction } from 'src/app/model/prediction';
import { PREDICTIONS } from 'src/app/model/predictionTempData';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user';
import { AccountService } from 'src/app/home/account-service';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-profilepage',
  templateUrl: './profilepage.component.html',
  styleUrls: ['./profilepage.component.css']
})
export class ProfilepageComponent implements OnInit {
  account$: Observable<User>;
  user: User;
  predictions: Prediction[];
  predictions$: Observable<Prediction[]>;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: AccountService
    ) { }

  ngOnInit(): void {
    this.account$ = this.service.userFromAPI;
    this.account$.subscribe(data => {
      this.user = data;
      let x = this.service.getPredictionsByUser(this.user.username);
      x.subscribe(dt => {
        this.predictions = dt;
      })
    });
  }

  updateUser() {
      console.log("update user")
    }

  goToHomePage() {
    this.router.navigate(['homepage', this.user.username]);
  }

}
