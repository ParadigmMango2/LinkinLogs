export enum LogLevel {
  Error = "error",
  Notice = "notice"
  // more enums for a real log
}

export type LogLine = {
  //LineId,Time,Level,Content,EventId,EventTemplate
  lineId: number;
  time: Date;
  level: LogLevel;
  content: string;
  eventId: string;
  eventTemplate: string;
}
