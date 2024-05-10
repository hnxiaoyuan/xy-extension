package org.example.extension.configuration;

import java.lang.annotation.*;

/**
 * ParameterBinding
 *
 * @author dm-ai
 * @date 2023/5/17
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParameterBinding {
    String value();
}
