import { Pipe, PipeTransform } from '@angular/core';
import { LogLine } from '../models/log-line';

@Pipe({
  name: 'filterLogs',
})
export class FilterLogsPipe implements PipeTransform {

  transform(logs: LogLine[], minLine: number, maxLine: number): LogLine[] {
    return logs.filter(log => {
      return log.lineId >= minLine && log.lineId <= maxLine;
    });
  }

}
