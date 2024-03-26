import { TestBed } from '@angular/core/testing';

import { SpecificationFileService } from './specification-file.service';

describe('SpecificationFileService', () => {
  let service: SpecificationFileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SpecificationFileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
