import { TestBed } from '@angular/core/testing';

import { ShowUserDataService } from './show-user-data.service';

describe('ShowUserDataService', () => {
  let service: ShowUserDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShowUserDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
