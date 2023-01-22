package com.matildamared;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public GreetResponse greet() {
        return new GreetResponse(
                "Hello, friend!",
                List.of("JavaScript", "TypeScript", "Node.js", "CSS"),
                new Person("Matilda", 32)
        );
    }

    record Person(String name, int age) {
    }

    record GreetResponse(String greet, List<String> favoriteProgrammingLanguages, Person person) {

    }
}
