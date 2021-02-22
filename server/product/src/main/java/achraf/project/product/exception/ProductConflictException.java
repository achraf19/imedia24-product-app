package achraf.project.product.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ResponseStatus(value = HttpStatus.CONFLICT)
public class ProductConflictException extends RuntimeException {
    
    String message;
}
