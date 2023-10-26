package com.springmvc.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValidImageValidator.class})
public @interface ValidImage {
	String message() default "File image format is incorrect.";
	String[] type();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
