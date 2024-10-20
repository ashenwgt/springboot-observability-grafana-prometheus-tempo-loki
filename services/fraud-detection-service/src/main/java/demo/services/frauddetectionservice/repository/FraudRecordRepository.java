package demo.services.frauddetectionservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository for managing fraud records in the database.
 * It provides data access operations to query fraud information.
 */
@Repository
@RequiredArgsConstructor
public class FraudRecordRepository {

    private final JdbcClient jdbcClient;

    /**
     * Checks if there is a fraud record for the given customer ID.
     *
     * @param customerId the ID of the customer
     * @return true if the customer has a fraud record, false otherwise
     */
    @Transactional(readOnly = true)
    public boolean existsByCustomerId(int customerId) {
        // SQL query to check if a fraud record exists for the customer
        var sql = """
                SELECT COUNT(*) AS fraud_record_exists
                FROM fraud_records
                WHERE customerId = :customerId;
                """;

        // Execute the query and return true if a record is found
        return jdbcClient.sql(sql)
                .param("customerId", customerId)
                .query(Integer.class)
                .single() > 0;
    }
}
