import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../model/user';
import { USERS } from '../model/userTempData';

@Injectable({
  providedIn: 'root',
})
export class AccountService {

  constructor() { }

  getAccounts(): Observable<User[]> {
    return of(USERS);
  }

  getAccount(username: string | string) {
    return this.getAccounts().pipe(
      map((account: User[]) => account.find(acct => acct.username === username)!)
    );
  }
}