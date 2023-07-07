package br.com.fiap.lanchonete.application.apis.rest.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
    }
}
