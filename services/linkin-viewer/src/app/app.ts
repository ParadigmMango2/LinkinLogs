import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LogView } from './components/log-view/log-view';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, LogView],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('linkin-viewer');
}
