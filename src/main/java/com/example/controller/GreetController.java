package com.example.controller;

import com.example.service.GreetingService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Mono;

@Controller("/greet")
public class GreetController {

  private final GreetingService greetingService;

  public GreetController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  @Get("/{name}")
  public Mono<String> greet(String name) {
    return greetingService.getGreeting(name);
  }
}
