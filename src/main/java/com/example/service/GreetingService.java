package com.example.service;


import com.example.client.GreetingClient;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

@Singleton
public class GreetingService {

  private final GreetingClient greetingClient;

  public GreetingService(GreetingClient greetingClient) {
    this.greetingClient = greetingClient;
  }

  public Mono<String> getGreeting(String name) {
    return greetingClient.getGreeting(name);
  }
}
