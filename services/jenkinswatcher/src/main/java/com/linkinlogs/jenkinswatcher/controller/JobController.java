package com.linkinlogs.jenkinswatcher.controller;

import com.linkinlogs.jenkinswatcher.model.JobModel;
import com.linkinlogs.jenkinswatcher.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("jobs")
public class JobController {
    @Autowired
    JobService jobService;

    @GetMapping("")
    public ResponseEntity<List<JobModel>> getAllJobs() {
        return jobService.getJobs();
    }
}
