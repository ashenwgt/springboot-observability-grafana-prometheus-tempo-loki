package demo.services.loanservice.dto;

import demo.services.loanservice.entity.Loan;
import demo.services.loanservice.entity.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Data Transfer Object for Loan entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanDTO {

    private String loanId;
    private String customerName;
    private int customerId;
    private BigDecimal amount;
    private LoanStatus loanStatus;

    /**
     * Converts a Loan entity to a LoanDto.
     *
     * @param loan Loan entity
     * @return LoanDto
     */
    public static LoanDTO from(Loan loan) {
        return LoanDTO.builder()
                .loanId(loan.getLoanId())
                .customerName(loan.getCustomerName())
                .customerId(loan.getCustomerId())
                .amount(loan.getAmount())
                .loanStatus(loan.getLoanStatus())
                .build();
    }
}
