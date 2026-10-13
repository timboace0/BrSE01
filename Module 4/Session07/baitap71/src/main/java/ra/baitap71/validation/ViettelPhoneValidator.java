package ra.baitap71.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class ViettelPhoneValidator
        implements ConstraintValidator<ViettelPhone, String> {

    private static final String[] VIETTEL_PREFIXES = {
            "086", "096", "097", "098",
            "032", "033", "034", "035",
            "036", "037", "038", "039"
    };

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return true;
        }

        if (!value.matches("^0[0-9]{9}$")) {
            return false;
        }

        for (String prefix : VIETTEL_PREFIXES) {
            if (value.startsWith(prefix)) {
                return true;
            }
        }

        return false;
    }
}
