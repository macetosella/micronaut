package com.example.client;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

@Singleton
public class GreetingClient {

  @Inject
  @Client("http://jsonplaceholder.typicode.com")
  HttpClient client;

  public Mono<String> getGreeting(String name) {
    return Mono.from(client.retrieve(HttpRequest.GET("/posts/1"), String.class));
  }
}

