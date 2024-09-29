package com.await.springmvcblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Spring MVC Blog application.
 * This is the entry point of the Spring Boot application.
 */
@SpringBootApplication
public class SpringMvcBlogApplication {

    /**
     * The main method that starts the Spring Boot application.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        // Run the application by invoking the Spring Boot run method
        SpringApplication.run(SpringMvcBlogApplication.class, args);
    }
}
