package dev.ramana.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionDTO {
    private HttpStatus httpStatus;

    private String message;

    public ExceptionDTO(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
