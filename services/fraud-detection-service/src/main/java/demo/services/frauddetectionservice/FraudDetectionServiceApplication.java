package demo.services.frauddetectionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Fraud Detection Service application.
 * This bootstraps the Spring Boot application.
 */
@SpringBootApplication
public class FraudDetectionServiceApplication {

	public static void main(String[] args) {
		// Launch the Spring Boot application
		SpringApplication.run(FraudDetectionServiceApplication.class, args);
	}
}
