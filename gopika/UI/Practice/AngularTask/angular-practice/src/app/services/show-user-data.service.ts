import { UserDataService } from '../constants/constants';
import { IUser } from './../models/user';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ShowUserDataService {
  constructor() {}
  show(user: IUser): void {
    console.log(UserDataService.WelcomeToSevice);
    console.log(user.name);
    console.log(user.email);
  }
}
// tradeservice
//
// create trade if buy by trade succ elsee sell
