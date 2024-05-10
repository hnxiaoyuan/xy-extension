package org.example.extension.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author DM
 */
public class CustomizeValidator implements ConstraintValidator<CustomizeValid, Object> {
    private Class<? extends CustomizeValidation<Object>> validClazz;

    @Override
    public void initialize(CustomizeValid constraintAnnotation) {
        this.validClazz= constraintAnnotation.checkClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (this.validClazz == null){
            return true;
        }
        try {
            return this.validClazz.newInstance().validate(value);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
