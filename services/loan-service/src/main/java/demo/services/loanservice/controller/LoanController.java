package demo.services.loanservice.controller;

import demo.services.loanservice.dto.LoanDTO;
import demo.services.loanservice.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing loans.
 */
@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    /**
     * Retrieves a list of all loans.
     *
     * @return List of LoanDto
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LoanDTO> listAllLoans() {
        return loanService.listAllLoans();
    }

    /**
     * Endpoint to apply for a new loan.
     *
     * @param loanDTO DTO containing loan details
     * @return Result of loan application
     */
    @PostMapping
    public String applyLoan(@RequestBody LoanDTO loanDTO) {
        return loanService.applyLoan(loanDTO);
    }
}
