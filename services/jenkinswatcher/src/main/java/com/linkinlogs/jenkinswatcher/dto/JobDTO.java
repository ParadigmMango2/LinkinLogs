package com.linkinlogs.jenkinswatcher.dto;

import com.cdancy.jenkins.rest.domain.job.Job;
import com.linkinlogs.jenkinswatcher.model.JobModel;
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

    public static JobModel toModel(JobDTO dto) {
        if (dto == null) return null;

        JobModel model = new JobModel();
        model.setName(dto.getName());
        model.setUrl(dto.getUrl());
        model.setColor(dto.getColor());
        model.setClazz(dto.getClazz());
        return model;
    }
}

