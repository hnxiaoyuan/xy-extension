package org.example.extension.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author xiaoyuan
 */
@Documented
@Constraint(validatedBy = CustomizeValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface CustomizeValid {
    String message() default "customize valid error";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    /**
     * 校验的类
     */
    Class<? extends CustomizeValidation<Object>> checkClass();
}
