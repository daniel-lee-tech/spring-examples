package com.website.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class EnableImages implements WebMvcConfigurer  {
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {

        // allowing all urls that start with "/images/" to be redirected to project's /WEB-INF/images folder.
        // for example a url such as "/images/daniel.jpg" will actually be linked to "/WEB-INF/images/daniel.jpg"
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
    }
}
