package com.xyspring.extension.register;

import com.xyspring.extension.Extensible;
import com.xyspring.extension.Extension;
import com.xyspring.extension.ExtensionCoordinate;
import com.xyspring.extension.ExtensionRepository;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.ClassUtils;

public class ExtensionRegister {
    private final ExtensionRepository extensionRepository;

    public ExtensionRegister(ExtensionRepository extensionRepository) {
        this.extensionRepository = extensionRepository;
    }

    /**
     * 注册扩展点
     * @param extensionPoint 扩展点的bean
     */
    public void doRegistration(Object extensionPoint){
        Class<?>  extensionClass = extensionPoint.getClass();
        if (AopUtils.isAopProxy(extensionPoint)) {
            extensionClass = AopUtils.getTargetClass(extensionPoint);
        }
        Extension extensionAnn = AnnotatedElementUtils.findMergedAnnotation(extensionClass, Extension.class);
        ExtensionCoordinate extensionPointKey = calculateExtensionPoint(extensionAnn, extensionClass);
        extensionRepository.put(extensionPointKey, extensionPoint);
    }

    private ExtensionCoordinate calculateExtensionPoint(Extension extensionAnn, Class<?> clazz) {
        final Class<?>[] allInterfaces = ClassUtils.getAllInterfacesForClass(clazz);
        for (Class<?> infc : allInterfaces) {
            if (infc.isAnnotationPresent(Extensible.class)) {
                return new ExtensionCoordinate(infc, extensionAnn.scenario());
            }
        }
        throw new RuntimeException("Please assign a Extensible point interface for " + clazz);
    }
}
