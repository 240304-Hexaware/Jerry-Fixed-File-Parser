import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FixedFileListComponent } from './fixed-file-list.component';

describe('FixedFileListComponent', () => {
  let component: FixedFileListComponent;
  let fixture: ComponentFixture<FixedFileListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FixedFileListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FixedFileListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
