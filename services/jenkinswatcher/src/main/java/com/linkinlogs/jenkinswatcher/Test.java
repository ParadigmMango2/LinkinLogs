package com.linkinlogs.jenkinswatcher;

import com.cdancy.jenkins.rest.JenkinsClient;
import com.cdancy.jenkins.rest.domain.job.Job;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/test")
class Test {
  private JenkinsClient client = JenkinsClient.builder()
        .endPoint("http://localhost:9090")
        .apiToken("admin:examplepwd")
        .build();

  @GetMapping("/jobs")
  public List<Job> getJobs() {
    return client.api().jobsApi().jobList("").jobs();
  }
}
