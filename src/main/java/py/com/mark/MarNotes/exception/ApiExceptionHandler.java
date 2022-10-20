package py.com.mark.MarNotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiException e){
        ApiRequestException apiException = new ApiRequestException(
                e.getCode(),
                e.getMessage(),
                HttpStatus.BAD_REQUEST
                );
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
