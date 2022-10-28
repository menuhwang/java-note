package com.menu.webclient;

import com.menu.webclient.surport.GitHubClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.Collectors;

@SpringBootApplication
public class WebClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(WebClientApplication.class, args);
        GitHubClient gitHubClient = context.getBean(GitHubClient.class);
        System.out.println("Get user repos : " + gitHubClient.getUserRepos("menuhwang"));
    }

}
