package demo.services.loanservice.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for setting up a RestTemplate for interacting with external services.
 * Configures the RestTemplate to interact with the Fraud Detection Service.
 */
@Configuration
public class RestClientConfig {

    // Inject the Fraud Detection Service URL from application properties
    @Value("${fraud.service.url}")
    private String fraudServiceUrl;

    /**
     * Bean for creating a RestTemplate that communicates with the Fraud Detection Service.
     *
     * @param restTemplateBuilder A builder for creating RestTemplate instances with custom settings
     * @return RestTemplate instance with a predefined root URI for the Fraud Detection Service
     */
    @Bean
    public RestTemplate fraudServiceRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .rootUri(fraudServiceUrl)  // Base URI fetched from application properties
                .build();
    }
}
