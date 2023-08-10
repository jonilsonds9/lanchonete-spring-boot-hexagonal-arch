package br.com.fiap.lanchonete.infrastracture.apis.rest.exceptions;

public record ValidationError(String field, String message) {
}
