package br.com.fiap.lanchonete.infrastracture.apis.rest.validations;

import br.com.fiap.lanchonete.infrastracture.persistence.repositories.SpringClientesRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCpfValidator implements ConstraintValidator<UniqueCpf, String> {

    private final SpringClientesRepository clientesRepository;

    public UniqueCpfValidator(SpringClientesRepository userRepository) {
        this.clientesRepository = userRepository;
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        return clientesRepository.findByCpf(cpf).isEmpty();
    }
}
