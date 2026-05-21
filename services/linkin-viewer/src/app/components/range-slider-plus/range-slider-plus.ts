import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatInput } from '@angular/material/input';
import { MatSliderModule } from '@angular/material/slider';

@Component({
  selector: 'app-range-slider-plus',
  imports: [MatSliderModule, MatInput, FormsModule],
  templateUrl: './range-slider-plus.html',
  styleUrl: './range-slider-plus.scss',
})
export class RangeSliderPlus {
  min: number = 0;
  max: number = 100;
}
