package br.com.fiap.lanchonete.infrastracture.apis.rest.exceptions;

public class PaymentException extends RuntimeException {

    public PaymentException(String message) {
        super(message);
    }

    public PaymentException() {
    }
}
