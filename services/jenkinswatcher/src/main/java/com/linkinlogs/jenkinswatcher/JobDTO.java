package com.linkinlogs.jenkinswatcher;

import com.cdancy.jenkins.rest.domain.job.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {
    private String name;
    private String url;
    private String color;

    public static JobDTO fromJob(Job job) {
        if (job == null) {
            return null;
        }
        return new JobDTO(
            job.name(),
            job.url(),
            job.color()
        );
    }
}

