package pl.coderslab.genealogy.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName("error")
public class CustomError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String code;

    private CustomError() {
        timestamp = LocalDateTime.now();
    }

    public CustomError(Throwable t) {
        this();
        this.message = t.getLocalizedMessage();
    }
    public CustomError(ResourceNotFoundException resourceNotFoundException) {
        this();
        this.code = resourceNotFoundException.getErrorCode();
        this.message = resourceNotFoundException.getLocalizedMessage();
    }
    public CustomError(RelationAlreadyExistException relationAlreadyExistException) {
        this();
        this.code = relationAlreadyExistException.getErrorCode();
        this.message = relationAlreadyExistException.getLocalizedMessage();
    }
    public CustomError(RelationBadException relationBadException) {
        this();
        this.code = relationBadException.getErrorCode();
        this.message = relationBadException.getLocalizedMessage();
    }
    public CustomError(ResourceAlreadyExistException resourceAlreadyExistException) {
        this();
        this.code = resourceAlreadyExistException.getErrorCode();
        this.message = resourceAlreadyExistException.getLocalizedMessage();
    }
}