package com.linkinlogs.jenkinswatcher.dao;

import com.linkinlogs.jenkinswatcher.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDAO extends JpaRepository<JobModel, Integer> {
}
