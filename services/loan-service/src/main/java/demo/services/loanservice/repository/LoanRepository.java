package demo.services.loanservice.repository;

import demo.services.loanservice.entity.Loan;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Repository layer for performing CRUD operations on loans.
 */
@Repository
@RequiredArgsConstructor
@Observed
public class LoanRepository {

    private final JdbcClient jdbcClient;

    /**
     * Retrieves all loans from the database.
     *
     * @return List of Loan entities
     */
    @Transactional(readOnly = true)
    public List<Loan> findAll() {
        String findQuery = "SELECT id, loanId, customerName, customerId, amount, loanStatus FROM loans";
        return jdbcClient.sql(findQuery).query(Loan.class).list();
    }

    /**
     * Saves a new loan to the database and returns the generated ID.
     *
     * @param loan Loan entity to be saved
     * @return Generated loan ID
     */
    @Transactional
    public Long save(Loan loan) {
        String insertQuery = "INSERT INTO loans(loanId, customerName, customerId, amount, loanStatus) VALUES(?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient.sql(insertQuery)
                .param(1, UUID.randomUUID().toString())
                .param(2, loan.getCustomerName())
                .param(3, loan.getCustomerId())
                .param(4, loan.getAmount())
                .param(5, loan.getLoanStatus().toString())
                .update();

        return keyHolder.getKeyAs(Long.class);
    }
}
