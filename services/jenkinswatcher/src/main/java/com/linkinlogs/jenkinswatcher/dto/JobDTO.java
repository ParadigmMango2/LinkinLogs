package com.linkinlogs.jenkinswatcher.dto;

import com.cdancy.jenkins.rest.domain.job.Job;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobDTO {
    private String name;
    private String url;
    private String color;
    private String clazz;

    public static JobDTO fromJob(Job job) {
        if (job == null) return null;

        JobDTO dto = new JobDTO();
        dto.setName(job.name());
        dto.setUrl(job.url());
        dto.setColor(job.color());
        dto.setClazz(job.clazz());
        return dto;
    }
}

