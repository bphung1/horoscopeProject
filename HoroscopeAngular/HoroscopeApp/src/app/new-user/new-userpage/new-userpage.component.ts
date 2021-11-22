import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-userpage',
  templateUrl: './new-userpage.component.html',
  styleUrls: ['./new-userpage.component.css']
})
export class NewUserpageComponent implements OnInit {
  submitted = false;

  @ViewChild('f', { static: false }) signupForm: NgForm;

  constructor(private router : Router) { }




  ngOnInit(): void {
  }

  addNewUser() {
      this.router.navigate(['/horoscope']);
    }

}
