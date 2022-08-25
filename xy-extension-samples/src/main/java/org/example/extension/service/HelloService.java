package org.example.extension.service;

import com.xyspring.extension.Extensible;

@Extensible
public interface HelloService {
    void sayHello();
    String helloReturn(String hello);
}
