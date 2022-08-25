package com.xyspring.extension;

import com.xyspring.extension.register.ExtensionRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

/**
 * 扩展启动注册bean
 * @author xiaoyuan
 * @date 2022-08-19 12:38 AM
 */
public class ExtensionBootstrap extends ApplicationObjectSupport implements BeanPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(ExtensionBootstrap.class);

    private final ExtensionRegister extensionRegister;

    public ExtensionBootstrap(ExtensionRegister extensionRegister) {
        this.extensionRegister = extensionRegister;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName){
        final ApplicationContext applicationContext = getApplicationContext();
        if (applicationContext == null) {
            return bean;
        }
        final Extensible extensible;
        try {
            extensible = applicationContext.findAnnotationOnBean(beanName, Extensible.class);
        } catch (NoSuchBeanDefinitionException exception){
            return bean;
        }
        if (extensible != null) {
            logger.info("Register extension bean: {}", beanName);
            extensionRegister.doRegistration(bean);
        }
        return bean;
    }
}
