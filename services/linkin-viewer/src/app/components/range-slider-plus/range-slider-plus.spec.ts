import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RangeSliderPlus } from './range-slider-plus';

describe('RangeSliderPlus', () => {
  let component: RangeSliderPlus;
  let fixture: ComponentFixture<RangeSliderPlus>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RangeSliderPlus]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RangeSliderPlus);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
