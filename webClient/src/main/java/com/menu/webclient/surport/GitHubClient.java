package com.menu.webclient.surport;

import com.menu.webclient.config.ApiKey;
import com.menu.webclient.domain.Repository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GitHubClient {
    private WebClient.Builder builder;
    private WebClient client;

    public GitHubClient(WebClient.Builder builder, ApiKey apiKey)  {
        this.builder = builder;
        this.client = this.builder.baseUrl("https://api.github.com")
                .defaultHeader("Authorization", apiKey.getGitToken())
                .build();
    }

    public List<Repository> getUserRepos(String username) {
        return this.client.get().uri(uriBuilder ->
                     uriBuilder.path("/users")
                             .path("/" + username)
                             .path("/repos")
                             .queryParam("sort", "pushed")// 최근 push 정렬
                             .queryParam("per_page", "5")// 페이징 요소 5개 제한
                             .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Repository.class)
                .doOnError(throwable -> {
                    System.out.printf("해당 깃허브 유저가 없습니다. gitUsername=%s\n", username);
                })
                .collect(Collectors.toList())
                .share().block();
    }
}
