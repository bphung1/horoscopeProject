import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  submitted = false;

  @ViewChild('f', { static: false }) signupForm: NgForm;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }

  goToCreateNewUser() {
    this.router.navigate(['/new-user']);
  }

  generateHoroscope() {
    this.router.navigate(['/horoscope']);
  }

  onSubmit() {
    console.log("Hello world");
  }
}
