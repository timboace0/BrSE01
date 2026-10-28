package ra.baitap91.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = HandleFileImageValidation.class)
@Target({ElementType.METHOD,ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckFileImage {
    String message() default "File ảnh không được để trống | dưới 2MB | chỉ nhận file PNG, JPG, JPEG";

    Class<?>[] groups() default  {};

    Class<? extends Payload>[] payload() default {};
}
