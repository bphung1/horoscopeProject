import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewUserpageComponent } from './new-userpage.component';

describe('NewUserpageComponent', () => {
  let component: NewUserpageComponent;
  let fixture: ComponentFixture<NewUserpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewUserpageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewUserpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
