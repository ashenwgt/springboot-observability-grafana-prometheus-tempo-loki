package demo.services.frauddetectionservice.service;

import demo.services.frauddetectionservice.entity.LoanStatus;
import demo.services.frauddetectionservice.repository.FraudRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service for fraud detection logic.
 * It interacts with the repository to determine if a customer is flagged for fraud.
 */
@Service
@RequiredArgsConstructor
public class FraudDetectionService {

    private final FraudRecordRepository fraudRecordRepository;

    /**
     * Checks if the given customer ID has any fraud records.
     *
     * @param customerId the ID of the customer
     * @return LoanStatus APPROVED if no fraud records are found, otherwise REJECTED
     */
    public LoanStatus checkForFraud(int customerId) {
        // Use the repository to check if there is a fraud record for the given customer
        return fraudRecordRepository.existsByCustomerId(customerId) ? LoanStatus.REJECTED : LoanStatus.APPROVED;
    }
}
