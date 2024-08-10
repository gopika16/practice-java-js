import { Component, OnInit } from '@angular/core';
import { IUser } from '../../models/user';
import { PracticeDirective } from '../../constants/constants';

@Component({
  selector: 'app-practice-directives',
  templateUrl: './practice-directives.component.html',
  styleUrls: ['./practice-directives.component.css'],
})
export class PracticeDirectivesComponent implements OnInit {
  colorsList = ['red', 'green', 'blue', 'black', 'orange'];

  user: IUser;

  constructor() {
    this.user = <IUser>{
      name: PracticeDirective.Name,
      email: PracticeDirective.ExampleEmail,
    };
  }

  ngOnInit(): void {}
}
