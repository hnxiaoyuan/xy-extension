package com.xyspring.extension.configuration;

import com.xyspring.extension.ExtensionBootstrap;
import com.xyspring.extension.ExtensionExecutor;
import com.xyspring.extension.ExtensionRepository;
import com.xyspring.extension.register.ExtensionRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExtensionConfiguration {

    @Bean
    public ExtensionBootstrap extensionBootstrap(ExtensionRegister extensionRegister){
        return new ExtensionBootstrap(extensionRegister);
    }

    @Bean
    public ExtensionRepository extensionRepository(){
        return new ExtensionRepository();
    }

    @Bean
    public ExtensionRegister extensionRegister(ExtensionRepository extensionRepository){
        return new ExtensionRegister(extensionRepository);
    }

    @Bean
    public ExtensionExecutor extensionExecutor(ExtensionRepository extensionRepository){
        return new ExtensionExecutor(extensionRepository);
    }
}
