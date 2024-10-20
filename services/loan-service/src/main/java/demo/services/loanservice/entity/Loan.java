package demo.services.loanservice.entity;

import demo.services.loanservice.dto.LoanDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Entity representing a loan in the system.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Loan {

    private Long id;
    private String loanId;
    private String customerName;
    private int customerId;
    private BigDecimal amount;
    private LoanStatus loanStatus;

    /**
     * Converts a LoanDto to a Loan entity.
     *
     * @param loanDto Data transfer object containing loan details
     * @return Loan entity
     */
    public static Loan from(LoanDTO loanDto) {
        return Loan.builder()
                .loanId(loanDto.getLoanId())
                .amount(loanDto.getAmount())
                .customerId(loanDto.getCustomerId())
                .customerName(loanDto.getCustomerName())
                .build();
    }
}
