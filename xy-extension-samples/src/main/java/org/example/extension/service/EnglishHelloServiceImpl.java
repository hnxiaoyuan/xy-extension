package org.example.extension.service;

import com.xyspring.extension.Extension;
import org.springframework.stereotype.Service;

@Extension(scenario = "us")
@Service
public class EnglishHelloServiceImpl implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("I'm say English: Excuse me?");
    }

    @Override
    public String helloReturn(String hello) {
        return hello + " returned";
    }
}
