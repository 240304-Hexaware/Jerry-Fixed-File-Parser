import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecordsByFileComponent } from './records-by-file.component';

describe('RecordsByFileComponent', () => {
  let component: RecordsByFileComponent;
  let fixture: ComponentFixture<RecordsByFileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecordsByFileComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RecordsByFileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
