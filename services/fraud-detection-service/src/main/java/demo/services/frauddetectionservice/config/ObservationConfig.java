package demo.services.frauddetectionservice.config;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for enabling method observation for metrics collection.
 */
@Configuration
public class ObservationConfig {

    /**
     * Registers the ObservedAspect bean to enable metrics observation on annotated methods.
     *
     * @param registry The observation registry to track and export metrics
     * @return an ObservedAspect that applies observation to relevant methods
     */
    @Bean
    public ObservedAspect observedAspect(ObservationRegistry registry) {
        return new ObservedAspect(registry);
    }
}
