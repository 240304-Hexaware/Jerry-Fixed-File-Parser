import { TestBed } from '@angular/core/testing';

import { FixedFileService } from './fixed-file.service';

describe('FixedFileService', () => {
  let service: FixedFileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FixedFileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
