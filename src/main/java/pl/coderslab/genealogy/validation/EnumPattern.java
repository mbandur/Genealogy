package pl.coderslab.genealogy.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumPatternValidator.class)
public @interface EnumPattern {

    String regexp();

    String message() default "{pl.coderslab.project.validation.EnumVal.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}