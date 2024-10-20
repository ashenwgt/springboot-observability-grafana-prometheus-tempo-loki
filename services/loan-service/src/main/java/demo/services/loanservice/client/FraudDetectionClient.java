package demo.services.loanservice.client;

import demo.services.loanservice.entity.LoanStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Client for interacting with the Fraud Detection Service.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class FraudDetectionClient {

    private final RestTemplate fraudServiceRestTemplate;

    /**
     * Evaluates the loan by calling the Fraud Detection Service.
     *
     * @param customerId The customer ID to check for fraud
     * @return LoanStatus indicating approval or rejection
     */
    public LoanStatus evaluateLoan(int customerId) {
        log.info("Calling Fraud Detection Service for customer id: {}", customerId);
        LoanStatus response = fraudServiceRestTemplate.exchange("/fraud/check?customerId=" + customerId,
                        HttpMethod.GET, null, LoanStatus.class)
                .getBody();
        log.info("Fraud Detection Service response: {}", response);
        return response;
    }
}
