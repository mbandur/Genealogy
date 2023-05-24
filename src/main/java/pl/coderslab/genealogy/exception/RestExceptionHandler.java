package pl.coderslab.genealogy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> handleResourceNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(new CustomError(ex), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RelationBadException.class)
    public ResponseEntity<CustomError> handleRRelationBadException(RelationBadException ex) {
        return new ResponseEntity<>(new CustomError(ex), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RelationAlreadyExistException.class)
    public ResponseEntity<CustomError> handleRelationAlreadyExistException(RelationAlreadyExistException ex) {
        return new ResponseEntity<>(new CustomError(ex), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<CustomError> handleResourceAlreadyExistException(ResourceAlreadyExistException ex) {
        return new ResponseEntity<>(new CustomError(ex), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CustomError> handleHttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException) {
        return new ResponseEntity<>(new CustomError(new BadDateFormatException("Invalid date format in eventDate. Must match: yyyy-MM-dd")), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<CustomError> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) {
        return new ResponseEntity<>(new CustomError(new BadParamFormatException("Invalid param format")), HttpStatus.CONFLICT);
    }
}