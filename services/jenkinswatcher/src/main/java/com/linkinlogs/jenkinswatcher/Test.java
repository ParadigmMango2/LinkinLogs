package com.linkinlogs.jenkinswatcher;

import com.cdancy.jenkins.rest.JenkinsClient;
import com.cdancy.jenkins.rest.domain.job.Job;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/test")
public class Test {
  private JenkinsClient client = JenkinsClient.builder()
        .endPoint(String.format("%s://%s:%s", System.getenv("JENKINS_PROTOCOL"), System.getenv("JENKINS_URL"), System.getenv("JENKINS_PORT")))
        .apiToken(String.format("%s:%s", System.getenv("JENKINS_USER"), System.getenv("JENKINS_TOKEN")))
        .build();

  @GetMapping("/jobs")
  public List<Job> getJobs() {
    return client.api().jobsApi().jobList("").jobs();
  }
}
