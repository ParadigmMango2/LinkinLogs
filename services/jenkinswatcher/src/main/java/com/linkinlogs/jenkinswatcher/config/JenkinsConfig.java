package com.linkinlogs.jenkinswatcher.config;

import com.cdancy.jenkins.rest.JenkinsClient;
import com.linkinlogs.jenkinswatcher.factory.JenkinsConnectionFactory;
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
    public JenkinsConnectionFactory jenkinsConnectionFactory() {
        String baseUrl = String.format("%s://%s:%s", protocol, url, port);
        String credentials = user + ":" + token;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

        return new JenkinsConnectionFactory(baseUrl, encodedCredentials);
    }
}
