package br.com.fiap.lanchonete.infrastracture.apis.rest.validations;

import br.com.fiap.lanchonete.infrastracture.persistence.repositories.SpringClientesRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final SpringClientesRepository clientesRepository;

    public UniqueEmailValidator(SpringClientesRepository userRepository) {
        this.clientesRepository = userRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return clientesRepository.findByEmail(email).isEmpty();
    }
}
