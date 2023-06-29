package br.com.fiap.lanchonete.domain.validations;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NotBlankValidator.class)
public @interface NotBlank {
    String message() default "O campo não pode ser nulo ou vazio";
    Class<?>[] groups() default {};
}
