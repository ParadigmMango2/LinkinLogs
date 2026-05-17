import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { map, tap } from 'rxjs';

import Papa from 'papaparse';
import { LogLevel, LogLine } from '../models/log-line';

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
      map((result) => result.data.map((row: any) => ({
        lineId: row['LineId'],
        time: row['Time'],
        level: row['Level'],
        content: row['Content'],
        eventId: row['EventId'],
        eventTemplate: row['EventTemplate']
      }) as LogLine)),
      // tap((parsed) => console.log(parsed))
    );

    return processed;
  }
}
