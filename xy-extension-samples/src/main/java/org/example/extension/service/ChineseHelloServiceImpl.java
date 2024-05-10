package org.example.extension.service;

import com.xyspring.extension.Extension;
import org.springframework.stereotype.Service;

/**
 * @author xiaoyuan
 */
@Extension(scenario = "china")
@Service
public class ChineseHelloServiceImpl implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("我是中文的: 嗨，你好！");
    }

    @Override
    public String helloReturn(String hello) {
        return hello + " 返回！";
    }
}
