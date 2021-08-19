package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class CorsGlobalConfiguration {

    @Bean
    public WebMvcConfigurer addMapping(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/todos")
                        .allowedOrigins("http://localhost:8080")
                        .allowedMethods("GET", "PUT" ,"POST", "DELETE");
            }
        };
    }
}
