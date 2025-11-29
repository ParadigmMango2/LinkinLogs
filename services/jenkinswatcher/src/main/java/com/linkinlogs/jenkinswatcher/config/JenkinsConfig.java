package com.linkinlogs.jenkinswatcher.config;

import com.cdancy.jenkins.rest.JenkinsClient;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@Configuration
public class JenkinsConfig {
    @Value("${jenkins.protocol}")
    private String protocol;

    @Value("${jenkins.url}")
    private String url;

    @Value("${jenkins.port}")
    private String port;

    @Value("${jenkins.user}")
    private String user;

    @Value("${jenkins.token}")
    private String token;

    @Bean
    public JenkinsClient jenkinsClient() {
        return JenkinsClient.builder()
                .endPoint(String.format("%s://%s:%s", protocol, url, port))
                .apiToken(String.format("%s:%s", user, token))
                .build();
    }

    @Bean
    public Connection jenkinsConnection() {
        String credentials = System.getenv("JENKINS_USER") + ":" + System.getenv("JENKINS_TOKEN");
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

        return Jsoup.connect(String.format("%s://%s:%s/log", protocol, url, port))
                .header("Authorization", "Basic " + encodedCredentials);
    }
}
