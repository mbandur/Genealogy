package pl.coderslab.genealogy.exception;

public class RelationAlreadyExistException extends RuntimeException {

    private String errorCode = "CODE001";

    public static RelationAlreadyExistException forIds(String id1, String id2) {
        return new RelationAlreadyExistException(String.format("Relation with id1 = %s and id2 = %s is already exist", id1, id2));
    }

    public RelationAlreadyExistException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public RelationAlreadyExistException(String message) {
        super(message);
    }

    public String getErrorCode() {
        return errorCode;
    }
}