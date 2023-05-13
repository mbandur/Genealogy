package pl.coderslab.genealogy.exception;

public class ResourceAlreadyExistException extends RuntimeException {

    private String errorCode = "CODE003";

    public static ResourceAlreadyExistException forId(String id) {
        return new ResourceAlreadyExistException(String.format("Resource with id = %s is already exist", id));
    }

    public ResourceAlreadyExistException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ResourceAlreadyExistException(String message) {
        super(message);
    }

    public String getErrorCode() {
        return errorCode;
    }
}