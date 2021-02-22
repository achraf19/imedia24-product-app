package achraf.project.category.exception;

import java.time.LocalDateTime;
import java.util.Date;

import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CategoryConflictException.class)
    public ResponseEntity<?> CategoryConflictExceptionHandler(CategoryConflictException ex) {

        ApiError apiError = new ApiError(org.springframework.http.HttpStatus.CONFLICT, LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity<>(apiError, org.springframework.http.HttpStatus.CONFLICT);

    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<?> CategoryNotFoundExceptionHandler(CategoryNotFoundException ex) {

        ApiError apiError = new ApiError(org.springframework.http.HttpStatus.NOT_FOUND, LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity<>(apiError, org.springframework.http.HttpStatus.NOT_FOUND);

    }
    
}
