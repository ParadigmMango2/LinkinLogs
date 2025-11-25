package com.linkinlogs.jenkinswatcher;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.Base64;

@SpringBootApplication
public class JenkinswatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinswatcherApplication.class, args);
	}

    @Bean
    public CommandLineRunner testRunner() {
        return args -> {
            System.out.println("hi");

            String credentials = System.getenv("JENKINS_USER") + ":" + System.getenv("JENKINS_TOKEN");
            String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
            Connection connection = Jsoup.connect(
                    String.format("%s://%s:%s/log", System.getenv("JENKINS_PROTOCOL"),
                            System.getenv("JENKINS_URL"), System.getenv("JENKINS_PORT")))
                    .header("Authorization", "Basic " + encodedCredentials);

            Document doc = connection.get();

            Elements logLinks = doc.select("#logRecorders .jenkins-table__link");

            System.out.println(logLinks);
            System.out.println(logLinks.first().html());
            System.out.println(logLinks.first().attr("href"));
//            Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
        };
    }

}
