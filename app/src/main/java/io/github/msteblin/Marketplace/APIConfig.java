package io.github.msteblin.Marketplace;

import io.github.msteblin.MoySkladAPI.APIClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIConfig {
    @Bean
    APIClient apiClient() {
        return new APIClient();
    }
}
