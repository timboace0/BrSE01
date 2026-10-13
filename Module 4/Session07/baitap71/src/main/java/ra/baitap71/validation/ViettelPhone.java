package ra.baitap71.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ViettelPhoneValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface ViettelPhone {
    String message() default "Số điện thoại không thuộc nhà mạng Viettel";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
