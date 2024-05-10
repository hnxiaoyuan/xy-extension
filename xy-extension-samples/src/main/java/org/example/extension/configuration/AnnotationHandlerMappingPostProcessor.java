package org.example.extension.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://techblog.bozho.net/customizing-parameter-names-when-binding-spring-mvc-command-objects/">参考</a>
 * 支持参数Controller中query参数绑定到实体属性进行自定义名称
 * 使用注解 {@link SupportsCustomizedBinding} 和
 * {@link ParameterBinding}一起使用
 * @author dm-ai
 * @date 2023/5/17
 */
@Configuration
public class AnnotationHandlerMappingPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RequestMappingHandlerAdapter) {
            RequestMappingHandlerAdapter handlerAdapter = (RequestMappingHandlerAdapter) bean;
            List<HandlerMethodArgumentResolver> argumentResolvers = handlerAdapter.getCustomArgumentResolvers();
            if (argumentResolvers == null) {
                argumentResolvers = new ArrayList<>();
            }
            argumentResolvers.add(new AnnotationServletModelAttributeResolver(false));
            handlerAdapter.setCustomArgumentResolvers(argumentResolvers);
        }
        return bean;
    }
}