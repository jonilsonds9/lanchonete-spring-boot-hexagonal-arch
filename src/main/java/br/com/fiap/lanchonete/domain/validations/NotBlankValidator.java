package br.com.fiap.lanchonete.domain.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotBlankValidator implements ConstraintValidator<NotBlank, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        return false;
    }
}
