import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-form-te',
  templateUrl: './form-te.component.html',
  styleUrls: ['./form-te.component.css']
})
export class FormTeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    console.log("hello");
  }

  registerUser(form: NgForm) {
    console.log(form.value.password);
    console.log(form.value.email);
  }
}
