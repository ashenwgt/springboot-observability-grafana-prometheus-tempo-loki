package demo.services.loanservice.service;

import demo.services.loanservice.client.FraudDetectionClient;
import demo.services.loanservice.dto.LoanDTO;
import demo.services.loanservice.entity.Loan;
import demo.services.loanservice.entity.LoanStatus;
import demo.services.loanservice.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer for handling loan operations.
 */
@Service
@RequiredArgsConstructor
public class LoanService {

    private final FraudDetectionClient fraudDetectionClient;
    private final LoanRepository loanRepository;

    /**
     * Fetches all loans and maps them to LoanDto objects.
     *
     * @return List of LoanDto
     */
    public List<LoanDTO> listAllLoans() {
        return loanRepository.findAll().stream()
                .map(LoanDTO::from)
                .collect(Collectors.toList());
    }

    /**
     * Applies for a loan by evaluating fraud status and saving the loan if approved.
     *
     * @param loanDto Data transfer object containing loan details
     * @return String indicating the result of the loan application
     */
    public String applyLoan(LoanDTO loanDto) {
        Loan loan = Loan.from(loanDto);
        LoanStatus loanStatus = fraudDetectionClient.evaluateLoan(loan.getCustomerId());
        loan.setLoanStatus(loanStatus);

        if (LoanStatus.APPROVED.equals(loanStatus)) {
            loanRepository.save(loan);
            return "Loan applied successfully";
        }
        return "Sorry! Your loan was not approved";
    }
}
