package com.example.Ask;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class GreetingController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Greeting";
    }


    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + " Nice to meet you.";
    }
    @GetMapping("/success")
    public ResponseEntity<String> success() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "SuccessHeader");
        return ResponseEntity.ok()
                .headers(headers)
                .body("Request was successful with a custom header!");
    }


    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        String error = "The requested resource was not found.";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody String data) {
        URI location = URI.create("/resource/123");
        return ResponseEntity.created(location)
                .body("Resource created successfully!");
    }

}
