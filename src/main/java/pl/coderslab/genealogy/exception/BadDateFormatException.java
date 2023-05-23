package pl.coderslab.genealogy.exception;

public class BadDateFormatException extends RuntimeException {

    private String errorCode = "CODE005";

    public BadDateFormatException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BadDateFormatException(String message) {
        super(message);
    }

    public String getErrorCode() {
        return errorCode;
    }
}