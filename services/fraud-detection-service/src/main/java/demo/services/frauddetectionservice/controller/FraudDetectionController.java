package demo.services.frauddetectionservice.controller;

import demo.services.frauddetectionservice.entity.LoanStatus;
import demo.services.frauddetectionservice.service.FraudDetectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for handling fraud detection-related requests.
 */
@RestController
@RequestMapping("/fraud")
@RequiredArgsConstructor
@Slf4j
public class FraudDetectionController {

    private final FraudDetectionService fraudDetectionService;

    /**
     * Endpoint to check if a customer has any fraud records.
     *
     * @param customerId the ID of the customer to check
     * @return LoanStatus APPROVED if no fraud records are found, otherwise REJECTED
     */
    @GetMapping("/check")
    public LoanStatus checkForFraud(@RequestParam int customerId) {
        log.info("Checking for fraud for customer id: {}", customerId);
        return fraudDetectionService.checkForFraud(customerId);
    }
}
