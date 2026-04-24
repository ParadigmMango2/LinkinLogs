import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-log-view',
  imports: [],
  templateUrl: './log-view.html',
  styleUrl: './log-view.scss',
})
export class LogView {
  tableHeaders = signal<string[]>([])

  ngOnInit() {
    this.tableHeaders.set(['1', '2', '3'])
  }
}
