import { Component, inject, signal } from '@angular/core';
import { LogsService } from '../../services/logs-service';
import { catchError } from 'rxjs';

@Component({
  selector: 'app-log-view',
  imports: [],
  templateUrl: './log-view.html',
  styleUrl: './log-view.scss',
})
export class LogView {
  logsService = inject(LogsService)
  tableHeaders = signal<string[]>([])
  log = signal<String>('');

  ngOnInit(): void {
    this.tableHeaders.set(['1', '2', '3'])


    this.logsService
      .getLogsFromApi()
      .pipe(
        catchError((err) => {
          console.error(err);
          throw err;
        })
      )
      .subscribe((lines) => {
        // this.log.set(lines);
      });
  }
}
