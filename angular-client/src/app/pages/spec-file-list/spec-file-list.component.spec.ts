import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecFileListComponent } from './spec-file-list.component';

describe('SpecFileListComponent', () => {
  let component: SpecFileListComponent;
  let fixture: ComponentFixture<SpecFileListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SpecFileListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SpecFileListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
