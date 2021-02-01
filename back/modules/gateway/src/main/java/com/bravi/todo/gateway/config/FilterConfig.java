package com.bravi.todo.gateway.config;

import com.bravi.todo.gateway.filter.RequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public RequestFilter simpleFilter() {
        return new RequestFilter();
    }

}
