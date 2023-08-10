package br.com.fiap.lanchonete.infrastracture.apis.rest.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {
    String message() default "Email já foi cadastrado";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}