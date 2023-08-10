package br.com.fiap.lanchonete.infrastracture.apis.rest.exceptions;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ErrorResponse errorResponse = buildErrorResponse(ex, HttpStatus.BAD_REQUEST,
                "Erro de validação. Verifique o campo 'erros' para obter detalhes.", request);

        ex.getBindingResult().getFieldErrors().forEach(fieldError -> errorResponse
                .addValidationError(fieldError.getField(), fieldError.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException exception,
                                                                 WebRequest request) {
        String message = "Falha ao encontrar o elemento solicitado";
        if (exception.getMessage() != null) {
            message = exception.getMessage();
        }
        logger.error(message, exception);
        return buildResponseEntityErrorResponse(exception, HttpStatus.NOT_FOUND, message, request);
    }

    @ExceptionHandler(PaymentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handlePaymentException(PaymentException exception,
                                                                 WebRequest request) {
        String message = "Problema no pagamento";
        if (exception.getMessage() != null) {
            message = exception.getMessage();
        }
        logger.error(message, exception);
        return buildResponseEntityErrorResponse(exception, HttpStatus.BAD_REQUEST, message, request);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleAllUncaughtException(Exception exception, WebRequest request) {
        String message = "Ocorreu um erro desconhecido";
        return buildResponseEntityErrorResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR, message, request);
    }

    private ResponseEntity<ErrorResponse> buildResponseEntityErrorResponse(Exception exception, HttpStatus httpStatus,
                                                                           String message,
                                                                           WebRequest request) {
        ErrorResponse errorResponse = buildErrorResponse(exception, httpStatus, message, request);
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

    private ErrorResponse buildErrorResponse(Exception exception, HttpStatus httpStatus,
                                                             String message,
                                                             WebRequest request) {
        return new ErrorResponse(httpStatus, message, ((ServletWebRequest) request).getRequest().getRequestURI());
    }
}
