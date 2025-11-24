package com.linkinlogs.jenkinswatcher.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LogService {

    public ResponseEntity<String> getLogs() {
        try {
            Path logPath = Paths.get("logs/app.log");
            String logContent = Files.readString(logPath);
            return ResponseEntity.ok(logContent);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error reading log file: " + e.getMessage());
        }
    }
}

