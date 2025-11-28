package com.linkinlogs.jenkinswatcher.service;

import com.linkinlogs.jenkinswatcher.dao.LogDAO;
import com.linkinlogs.jenkinswatcher.model.LogModel;
import lombok.SneakyThrows;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class LogService {
    @Autowired
    LogDAO logDAO;

    @SneakyThrows
    public ResponseEntity<List<LogModel>> fetchLogs() {
        String credentials = System.getenv("JENKINS_USER") + ":" + System.getenv("JENKINS_TOKEN");
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        Connection connection = Jsoup.connect(
                        String.format("%s://%s:%s/log", System.getenv("JENKINS_PROTOCOL"),
                                System.getenv("JENKINS_URL"), System.getenv("JENKINS_PORT")))
                .header("Authorization", "Basic " + encodedCredentials);

        Document doc = connection.get();

        Elements logLinks = doc.select("#logRecorders .jenkins-table__link");

        ArrayList<LogModel> logs = new ArrayList<LogModel>();

        for (Element logLink : logLinks) {
            LogModel logModel = new LogModel();
            logModel.setName(logLink.html());
            logModel.setUrl(logLink.attr("href"));

            logs.add(logModel);
        }

        logDAO.saveAll(logs);

        return ResponseEntity.ok(logs);
    }

    public ResponseEntity<String> getLogs() {
        try {
            Path logPath = Paths.get("logs/app.log");
            String logContent = Files.readString(logPath);
            return ResponseEntity.ok(logContent);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error reading log file: " + e.getMessage());
        }
    }
}

