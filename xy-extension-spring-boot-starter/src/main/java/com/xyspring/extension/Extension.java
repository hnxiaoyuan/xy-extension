package com.xyspring.extension;

import java.lang.annotation.*;

/**
 * 扩展点表示一块逻辑在不同的业务有不同的实现，使用@Extensible在接口上声明
 * 在具体实现的bean上使用@Extension标记实现的扩展点
 * @author xiaoyuan
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Extension {

    /**
     * 业务场景, 标记适用的业务场景
     */
    String scenario();
}
