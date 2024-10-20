package demo.services.loanservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Loan Service Application.
 * This bootstraps the Spring Boot application.
 */
@SpringBootApplication
public class LoanServiceApplication {

	public static void main(String[] args) {
		// Launch the Spring Boot application
		SpringApplication.run(LoanServiceApplication.class, args);
	}
}
