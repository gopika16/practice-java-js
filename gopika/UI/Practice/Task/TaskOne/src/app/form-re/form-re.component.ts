import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-form-re',
  templateUrl: './form-re.component.html',
  styleUrls: ['./form-re.component.css'],
})
export class FormReComponent implements OnInit {
  username = new FormControl('');
  password = new FormControl('');
  val: any;

  loginForm: FormGroup = this.builder.group({
    username: this.username,
    password: this.password,
  });
  // infoForm = new FormGroup({
  //   firstName: new FormControl(),
  //   lastName: new FormControl(),
  //   email: new FormControl(),
  //   password: new FormControl()
  // })

  constructor(private builder: FormBuilder) {}

  login() {
    console.log(this.loginForm.value);
    this.val = this.loginForm.value;
    console.log(this.val.username);
    console.log(this.val.password);
  }


  ngOnInit(): void {}
}

// // import { Component } from '@angular/core';
// //

// // @Component({
// //   selector: 'app-root',
// //   templateUrl:'./app.component.html',
// //   styleUrls: ['./app.component.css']
// // })
// export class AppComponent {
//   username = new FormControl('');
//   password = new FormControl('');

//   loginForm: FormGroup = this.builder.group({
//     username: this.username,
//     password: this.password,
//   });

//   constructor(private builder: FormBuilder) {}

//   login() {
//     console.log(this.loginForm.value);
//     const formData = this.loginForm.value;
//     const url = `https://example.com/${formData.firstName}/${formData.lastName}/${formData.email}`;
//     console.log('URL:', url);
//   }
// }
