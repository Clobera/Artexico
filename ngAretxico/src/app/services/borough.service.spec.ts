import { TestBed } from '@angular/core/testing';

import { BoroughService } from './borough.service';

describe('BoroughService', () => {
  let service: BoroughService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BoroughService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
