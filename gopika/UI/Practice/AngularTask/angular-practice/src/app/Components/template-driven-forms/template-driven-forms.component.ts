import { Component, OnInit } from '@angular/core';
import { IUser } from '../../models/user';
import { ShowUserDataService } from '../../services/show-user-data.service';

@Component({
  selector: 'app-template-driven-forms',
  templateUrl: './template-driven-forms.component.html',
  styleUrls: ['./template-driven-forms.component.css'],
})
export class TemplateDrivenFormsComponent implements OnInit {
  user: IUser;

  constructor(private showUserDataService: ShowUserDataService) {
    this.user = <IUser>{};
  }

  ngOnInit(): void {}

  submit(): void {
    this.showUserDataService.show(this.user);
  }
}
