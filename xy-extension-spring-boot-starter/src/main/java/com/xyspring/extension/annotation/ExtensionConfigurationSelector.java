package com.xyspring.extension.annotation;

import com.xyspring.extension.configuration.ExtensionConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ExtensionConfigurationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //加载对应的配置bean
        return new String[]{ExtensionConfiguration.class.getName()};
    }
}
