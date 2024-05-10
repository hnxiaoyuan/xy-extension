package org.example.extension.configuration;

import java.lang.annotation.*;

/**
 * SupportsCustomizedBinding
 *
 * @author dm-ai
 * @date 2023/5/17
 */
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SupportsCustomizedBinding {
}
