package com.sqli.negra.referenceproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:exception-message.properties")
    }
)
public class PropertyConfiguration {
}
