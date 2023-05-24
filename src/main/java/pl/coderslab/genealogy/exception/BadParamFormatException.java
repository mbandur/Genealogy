package pl.coderslab.genealogy.exception;

public class BadParamFormatException extends RuntimeException {

    private String errorCode = "CODE006";

    public BadParamFormatException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BadParamFormatException(String message) {
        super(message);
    }

    public String getErrorCode() {
        return errorCode;
    }
}