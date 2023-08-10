package br.com.fiap.lanchonete.infrastracture.apis.rest.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
    }
}
