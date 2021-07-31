package ch.selise.assessment.advice;

import ch.selise.assessment.exception.BadRequestException;
import ch.selise.assessment.exception.InvalidArgumentException;
import ch.selise.assessment.exception.RecordNotFoundException;
import ch.selise.assessment.exception.TransactionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestExceptionHandler(BadRequestException ex, WebRequest request) {
        this.logException(ex);
        return this.buildResponseEntity(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler({InvalidArgumentException.class, TransactionException.class})
    public ResponseEntity<?> invalidArgExceptionHandler(InvalidArgumentException ex, WebRequest request) {
        this.logException(ex);
        return this.buildResponseEntity(HttpStatus.NOT_ACCEPTABLE, ex);
    }


    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> recordNotFoundExceptionHandler(RecordNotFoundException ex, WebRequest request) {
        this.logException(ex);
        return this.buildResponseEntity(HttpStatus.NOT_FOUND, ex);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        this.logException(ex);
        return this.buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    private ResponseEntity<?> buildResponseEntity(HttpStatus status, Exception ex){
        return ResponseEntity
                .status(status)
                .body(ex.getMessage());
    }

    private void logException(Exception e){
        log.error(e.getMessage(), e);
    }
}
