package org.example.extension.controller;

import org.apache.commons.lang3.StringUtils;
import org.example.extension.service.ChineseHelloServiceImpl;
import org.example.extension.service.EnglishHelloServiceImpl;
import org.example.extension.service.HelloService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
public class HelloControllerOld {

    @Resource
    private ChineseHelloServiceImpl chineseHelloService;
    @Resource
    private EnglishHelloServiceImpl englishHelloService;

    @RequestMapping("/hello-world")
    public void hello(@RequestParam String name) {
        //业务场景
        final String scenario = name.length() > 1 ? "china" : "us";

        //方式一
        if (Objects.equals(scenario, "china")) {
            chineseHelloService.sayHello();
        } else if (Objects.equals(scenario, "us")) {
            englishHelloService.sayHello();
        }

        //方式二
        /*
        HelloService helloService = HelloServiceFactory.getService(scenario);
        helloService.sayHello();
         */
    }
}
