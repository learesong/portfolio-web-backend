package com.learesong.config;

import com.learesong.common.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Value("${cross.origin.host}")
    private String origin;

    @Value("${cross.origin.max-age}")
    private Long maxAge;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods(Constants.GET, Constants.POST)
                .allowedOrigins(origin)
                .maxAge(maxAge);
    }

}
