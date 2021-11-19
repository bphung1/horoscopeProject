import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HoroscopepageComponent } from './horoscopepage.component';

describe('HoroscopepageComponent', () => {
  let component: HoroscopepageComponent;
  let fixture: ComponentFixture<HoroscopepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HoroscopepageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HoroscopepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
