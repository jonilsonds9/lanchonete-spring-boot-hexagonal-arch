package br.com.fiap.lanchonete.infrastracture.exceptions;

// TODO: Arrumar exceptions
public class FalhaNoPagamentoException extends RuntimeException {

    public FalhaNoPagamentoException(String message) {
        super(message);
    }

    public FalhaNoPagamentoException() {
    }
}
