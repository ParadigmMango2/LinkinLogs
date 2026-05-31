import { Component, inject, signal } from '@angular/core';
import { LogsService } from '../../services/logs-service';
import { catchError, interval } from 'rxjs';
import { LogLine } from '../../models/log-line';
import { RangeSliderPlus } from '../range-slider-plus/range-slider-plus';
import { FilterLogsPipe } from '../../pipes/filter-logs-pipe';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-log-view',
  imports: [
    MatFormFieldModule, MatSelectModule, FormsModule, ReactiveFormsModule,
    RangeSliderPlus, FilterLogsPipe
  ],
  templateUrl: './log-view.html',
  styleUrl: './log-view.scss',
})
export class LogView {
  logsService = inject(LogsService)
  tableHeaders = signal<string[]>([])
  log = signal<LogLine[]>([]);

  // Inputs
  lineMin = signal<number>(0);
  lineMax = signal<number>(100);
  levels = new FormControl('');
  levelList: string[] = ['error', 'notice'];

  ngOnInit(): void {
    //LineId,Time,Level,Content,EventId,EventTemplate
    this.tableHeaders.set(['Line ID', 'Time', 'Level', 'Content', 'Event ID', 'Event Template']);

    this.logsService
      .getLogsFromApi()
      .pipe(
        catchError((err) => {
          console.error(err);
          throw err;
        })
      )
      .subscribe((lines) => {
        this.log.set(lines);
      });

    interval(1000)
      .subscribe(() => {
        console.log(this.levels.value);
      });
  }
}
