package org.example.extension.controller;

import com.xyspring.extension.ExtensionExecutor;
import org.example.extension.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {
    @Resource
    ExtensionExecutor extensionExecutor;

    @RequestMapping("/hello-world")
    public void hello(@RequestParam String name){
        //业务场景
        final String scenario = name.length() > 1 ? "china" : "us";
        //调用HelloService的sayHello方法
        extensionExecutor.executeVoid(HelloService.class, scenario, HelloService::sayHello);

        /*

        //调用HelloService的helloReturn方法
        String param1 = "hello";
        final String returnHello = extensionExecutor.execute(
                HelloService.class, scenario,
                func -> func.helloReturn(param1)
        );
        System.out.println(returnHello);

         */
    }
}
