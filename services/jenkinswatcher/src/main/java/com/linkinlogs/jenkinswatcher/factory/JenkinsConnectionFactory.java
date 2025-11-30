package com.linkinlogs.jenkinswatcher.factory;

import lombok.AllArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

@AllArgsConstructor
public class JenkinsConnectionFactory {
    private final String baseUrl;
    private final String encodedCredentials;

    public Connection createConnection(String path) {
        return Jsoup.connect(baseUrl + path)
                .header("Authorization", "Basic " + encodedCredentials);
    }
}
