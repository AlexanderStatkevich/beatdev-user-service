package by.beatdev.userservice.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation should point on fields that have unique constraint in database.
 */
@Documented
@Constraint(validatedBy = EntityExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEntity {

    String message() default "{constraints.UniqueEntity.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
