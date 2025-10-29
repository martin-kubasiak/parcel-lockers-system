package com.app.userservice.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ParcelMachineServiceApiConfig {
    @Value("${parcel-machine-service.base-url}")
    private String baseUrl;

    @Bean
    public RestClient restClient() {
        return RestClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }
}
