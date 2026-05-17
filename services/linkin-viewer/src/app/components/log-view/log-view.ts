import { Component, inject, signal } from '@angular/core';
import { LogsService } from '../../services/logs-service';
import { catchError } from 'rxjs';
import { LogLine } from '../../models/log-line';

@Component({
  selector: 'app-log-view',
  imports: [],
  templateUrl: './log-view.html',
  styleUrl: './log-view.scss',
})
export class LogView {
  logsService = inject(LogsService)
  tableHeaders = signal<string[]>([])
  log = signal<LogLine[]>([]);

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
  }
}
