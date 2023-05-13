package pl.coderslab.genealogy.exception;

public class ResourceNotFoundException extends RuntimeException {

    private String errorCode = "CODE004";

    public static ResourceNotFoundException forId(String id) {
        return new ResourceNotFoundException(String.format("Resource with id = %s not found", id));
    }

    public ResourceNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public String getErrorCode() {
        return errorCode;
    }
}