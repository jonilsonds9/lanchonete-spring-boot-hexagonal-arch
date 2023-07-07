package br.com.fiap.lanchonete.application.apis.rest.exceptions;

public record ValidationError(String field, String message) {
}
