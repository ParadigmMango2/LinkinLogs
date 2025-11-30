package com.linkinlogs.jenkinswatcher.dao;

import com.linkinlogs.jenkinswatcher.model.LogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDAO extends JpaRepository<LogModel, String> {
}
