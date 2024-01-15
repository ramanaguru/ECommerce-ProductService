package dev.ramana.productservice.exceptions;

import dev.ramana.productservice.dtos.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice? => act as an interceptor to methods annotated with @RequestMapping.
// One piece of advice can cut through all the controllers in the system.
// One @ExceptionHandler can deal with multiple exceptions.

@ControllerAdvice
public class GlobalExceptionDTO {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleNotFoundException(NotFoundException notFoundException) {
        return new ResponseEntity<>(new ExceptionDTO(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}