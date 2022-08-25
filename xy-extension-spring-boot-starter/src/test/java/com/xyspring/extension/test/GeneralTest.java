package com.xyspring.extension.test;

import org.junit.Test;

import java.util.Arrays;

public class GeneralTest {

    @Test
    public void testInterfaceClass(){
        final Class<?>[] interfaces = DemoService.class.getInterfaces();
        System.out.println(Arrays.toString(interfaces));

        final Class<?>[] interfaces2 = DemoServiceImpl.class.getInterfaces();
        System.out.println(DemoServiceImpl.class.getSuperclass());
        System.out.println(Arrays.toString(interfaces2));

       // System.out.println(getInterfaceImpl(DemoServiceImpl.class, IExtensionPoint.class));
    }

    private Class<?> getInterfaceImpl(Class<?> clazz, Class<?> interfaceClazz){
        for (Class<?> item : clazz.getInterfaces()) {
            if (item.equals(interfaceClazz)) {
                return clazz;
            }
            return getInterfaceImpl(item, interfaceClazz);
        }
        return null;
    }
}
