import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { map, tap } from 'rxjs';

import Papa from 'papaparse';
import { LogLevel } from '../models/log-line';

@Injectable({
  providedIn: 'root',
})
export class LogsService {
  http = inject(HttpClient);

  // Stub
  getLogsFromApi() {
    const url = 'https://raw.githubusercontent.com/logpai/loghub/refs/heads/master/Apache/Apache_2k.log_structured.csv';

    console.log('hi');

    const raw = this.http.get(url, { responseType: 'text' });

    var processed = raw.pipe(
      map((rawChunk) => Papa.parse(rawChunk, {
        header: true,
        skipEmptyLines: true,
        transform: (value, header) => {
          if (header === 'Time') {
            return new Date(value);
          } else if (header == 'LineId') {
            return +value;
          } else if (header == 'Level') {
            if (value === LogLevel.Error) {
              return LogLevel.Error;
            } else {
              return LogLevel.Notice;
            }
          }
          return value;
        },
      })),
      tap((parsed) => console.log(parsed))
    );

    console.log(processed);

    return processed;
  }
}
