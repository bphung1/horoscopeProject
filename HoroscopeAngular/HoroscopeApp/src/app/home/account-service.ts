import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../model/user';
import { USERS } from '../model/userTempData';

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AccountService {

  url = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  getAccounts(): Observable<User[]> {
    return of(USERS); 
  }

  userFromAPI: Observable<any>;
  birthdayIfAnonymous: string;

  //api call for get user
  getAccount (username: string | string, password: string | string) {
    let user = this.http.post<any>(this.url + '/login' , {
      'username': username,
      'password': password
    });
    this.userFromAPI = user;
    return user;
  }

  getPredictionsByUser(username: string | string) {
    return this.http.get<any>(this.url + '/' + username);
  }

  getHoroscope(username: string | string, birthday: string | string) {
    if (this.userFromAPI) {
      return this.http.post<any>(this.url + '/generate', {
        'username': username,
        'birthday': birthday
      });
    } else {
      return this.http.post<any>(this.url + '/generate', {
        'username': 'Anonymous',
        'birthday': birthday
      });
    }
  }

}