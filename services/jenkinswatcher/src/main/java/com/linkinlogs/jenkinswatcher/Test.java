package com.linkinlogs.jenkinswatcher;

import com.cdancy.jenkins.rest.JenkinsClient;
import com.cdancy.jenkins.rest.domain.job.Job;
import com.linkinlogs.jenkinswatcher.DTO.JobDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/test")
public class Test {
  private JenkinsClient client = JenkinsClient.builder()
        .endPoint(String.format("%s://%s:%s", System.getenv("JENKINS_PROTOCOL"), System.getenv("JENKINS_URL"), System.getenv("JENKINS_PORT")))
        .apiToken(String.format("%s:%s", System.getenv("JENKINS_USER"), System.getenv("JENKINS_TOKEN")))
        .build();

  @GetMapping("/jobs")
  public List<JobDTO> getJobs() {
    List<Job> jobs = client.api().jobsApi().jobList("").jobs();
    return jobs.stream()
        .map(JobDTO::fromJob)
        .collect(Collectors.toList());
  }
}
