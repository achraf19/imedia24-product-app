package achraf.project.product.exception;

import java.time.LocalDateTime;
import java.util.Date;

import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import achraf.project.product.exception.ApiError;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductConflictException.class)
    public ResponseEntity<?> CategoryConflictExceptionHandler(ProductConflictException ex) {

        ApiError apiError = new ApiError(org.springframework.http.HttpStatus.CONFLICT, LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity<>(apiError, org.springframework.http.HttpStatus.CONFLICT);

    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> CategoryNotFoundExceptionHandler(ProductNotFoundException ex) {

        ApiError apiError = new ApiError(org.springframework.http.HttpStatus.NOT_FOUND, LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity<>(apiError, org.springframework.http.HttpStatus.NOT_FOUND);

    }
    
}
