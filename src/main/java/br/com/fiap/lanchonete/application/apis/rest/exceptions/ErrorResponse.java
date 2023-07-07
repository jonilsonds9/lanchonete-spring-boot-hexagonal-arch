package br.com.fiap.lanchonete.application.apis.rest.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private final int status;
    private final String error;
    private final String message;
    private final String path;
    private List<ValidationError> errors;

    public ErrorResponse(HttpStatus httpStatus, String message, String path) {
        this.status = httpStatus.value();
        this.error = httpStatus.getReasonPhrase();
        this.message = message;
        this.path = path;
    }

    public void addValidationError(String field, String message) {
        if(Objects.isNull(errors)){
            errors = new ArrayList<>();
        }
        errors.add(new ValidationError(field, message));
    }
}
