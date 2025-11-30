package com.linkinlogs.jenkinswatcher;

import com.linkinlogs.jenkinswatcher.factory.JenkinsConnectionFactory;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Base64;

@SpringBootApplication
@EnableScheduling
public class JenkinswatcherApplication {
    @Autowired
    JenkinsConnectionFactory jenkinsConnectionFactory;

	public static void main(String[] args) {
		SpringApplication.run(JenkinswatcherApplication.class, args);
	}

    @Bean
    public CommandLineRunner testRunner() {
        return args -> {
            System.out.println("hi");

//            Connection connection = jenkinsConnectionFactory.createConnection("/log/rss");
//
//            Document doc = connection.get();
//
//            System.out.println(doc);
        };
    }

}
