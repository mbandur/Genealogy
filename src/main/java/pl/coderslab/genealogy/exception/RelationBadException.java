package pl.coderslab.genealogy.exception;

public class RelationBadException extends RuntimeException {

    private String errorCode = "CODE002";

    public static RelationBadException forIds(String id1, String id2) {
        return new RelationBadException(String.format("Relation with id1 = %s and id2 = %s is not possible", id1, id2));
    }

    public RelationBadException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public RelationBadException(String message) {
        super(message);
    }

    public String getErrorCode() {
        return errorCode;
    }
}