package com.await.springmvcblog;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * ServletInitializer class for configuring the application when deployed as a WAR file.
 * Extends SpringBootServletInitializer to customize the initialization of the Spring Boot application.
 */
public class ServletInitializer extends SpringBootServletInitializer {

    /**
     * Configures the application when deployed in a servlet container.
     *
     * @param application the SpringApplicationBuilder used to configure the application
     * @return the configured SpringApplicationBuilder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Specifies the main application class to start the Spring Boot application
        return application.sources(SpringMvcBlogApplication.class);
    }
}
