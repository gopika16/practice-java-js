import { Component, OnDestroy, OnInit } from '@angular/core';
import { HttpClientService } from 'src/app/Core/Http-client.service';

@Component({
  selector: 'app-api-task',
  templateUrl: './api-task.component.html',
  styleUrls: ['./api-task.component.css'],
})
export class ApiTaskComponent implements OnInit, OnDestroy {
  constructor(private _httpClientService: HttpClientService) {}

  ngOnInit(): void {}
  submit() {
    // this._httpClientService.multipleEndpoint();
  }
  ngOnDestroy(): void {
    console.log('Destroy : Api - Task');
  }
}
