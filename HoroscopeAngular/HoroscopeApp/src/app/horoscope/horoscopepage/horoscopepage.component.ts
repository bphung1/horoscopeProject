import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-horoscopepage',
  templateUrl: './horoscopepage.component.html',
  styleUrls: ['./horoscopepage.component.css']
})
export class HoroscopepageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  goToProfile() {
    this.router.navigate(['profile']);
  }
}
