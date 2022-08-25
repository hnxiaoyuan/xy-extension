package com.xyspring.extension;

import java.lang.annotation.*;

/**
 * <code>@Extensible</code> 仅在接口上使用可生效, 标识接口是可扩展的
 * @author xiaoyuan
 * @date 2022-08-19 AM
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Extensible {

}
