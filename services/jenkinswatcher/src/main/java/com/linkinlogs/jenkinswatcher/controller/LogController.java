package com.linkinlogs.jenkinswatcher.controller;

import com.linkinlogs.jenkinswatcher.model.LogModel;
import com.linkinlogs.jenkinswatcher.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("logs")
public class LogController {
    @Autowired
    LogService logService;

    @GetMapping("")
    public ResponseEntity<String> getLogs() {
        return logService.getLogs();
    }

    @GetMapping("fetch")
    public ResponseEntity<List<LogModel>> fetchLogs() {
        return logService.fetchLogs();
    }
}

