package hu.futureofmedia.task.contactsapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = InvalidArgumentException.class)
    public ResponseEntity<HttpStatus> handleInvalidArgumentException() {
        return ResponseEntity.badRequest().build();
    }
}
