package demo.services.frauddetectionservice.entity;

/**
 * Record representing a fraud record entity in the database.
 * It contains the fraud record details for a customer.
 *
 * @param id unique identifier for the fraud record
 * @param fraudRecordId unique identifier for the fraud record in the business context
 * @param customerId the ID of the customer associated with the fraud record
 * @param loanStatus the loan status of the customer (e.g., REJECTED if fraud detected)
 */
public record FraudRecord(Long id, String fraudRecordId, int customerId, LoanStatus loanStatus) {
}
