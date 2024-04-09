package gov.iti.jets.Exceptions;

public class InsufficientVacationBalanceException extends RuntimeException {
    public InsufficientVacationBalanceException(String message) {
        super(message);
    }
}