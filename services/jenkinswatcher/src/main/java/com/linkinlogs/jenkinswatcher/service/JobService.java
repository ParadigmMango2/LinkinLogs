package com.linkinlogs.jenkinswatcher.service;

import com.cdancy.jenkins.rest.JenkinsClient;
import com.cdancy.jenkins.rest.domain.job.Job;
import com.linkinlogs.jenkinswatcher.dao.JobDAO;
import com.linkinlogs.jenkinswatcher.dto.JobDTO;
import com.linkinlogs.jenkinswatcher.model.JobModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {
    @Autowired
    JobDAO jobDAO;

    @Autowired
    JenkinsClient jenkinsClient;

    public ResponseEntity<List<JobModel>> getJobs() {
        List<Job> jobs = jenkinsClient.api().jobsApi().jobList("").jobs();
        List<JobModel> jobModels = jobs.stream()
                .map(JobDTO::fromJob)
                .map(JobDTO::toModel)
                .collect(Collectors.toList());
        return new ResponseEntity<>(jobModels, HttpStatus.OK);
    }
}
