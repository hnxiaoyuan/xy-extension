package com.xyspring.extension.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 用于开启扩展功能的注解
 * @author xiaoyuan
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ExtensionConfigurationSelector.class)
public @interface EnableExtension {

}
