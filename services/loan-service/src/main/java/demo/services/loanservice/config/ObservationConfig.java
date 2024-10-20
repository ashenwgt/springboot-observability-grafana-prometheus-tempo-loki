package demo.services.loanservice.config;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up observation/metrics support.
 * ObservedAspect is used to enable method-level observation and metrics tracking.
 */
@Configuration
public class ObservationConfig {

    /**
     * Bean to register ObservedAspect, enabling method observation and metrics collection.
     *
     * @param registry The observation registry for tracking and exporting metrics
     * @return ObservedAspect object that applies metrics to observed methods
     */
    @Bean
    public ObservedAspect observedAspect(ObservationRegistry registry) {
        return new ObservedAspect(registry);
    }
}
