package br.com.fiap.lanchonete.infrastracture.apis.rest.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCpfValidator.class)
public @interface UniqueCpf {
    String message() default "CPF já foi cadastrado";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
