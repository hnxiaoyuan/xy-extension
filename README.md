# xy-extension
A spring extension

## 概述
目录结构：
<pre>
<code>xy-extension</code>
├──  <code>xy-extension-samples</code> 使用示例
├──  <code>xy-extension-spring-boot-starter</code> 扩展组件(使用时引入此项即可)
</pre>

参照alibaba COLA的扩展组件[cola-component-extension-starter](https://github.com/alibaba/COLA/tree/master/cola-components/cola-component-extension-starter)
并结合项目实际应用, 
简化版的扩展组件, 旨在通过统一的扩展形式来支撑业务的变化, 也是策略模式的一种应用,
代码十分简单,供学习记录参考使用。

## 使用介绍

1. 添加依赖,需要自己下载源码手动使用<code>mvn install</code>安装到本地maven库
```xml
<dependency>
  <groupId>com.xyspring.extension</groupId>
  <artifactId>xy-extension-spring-boot-starter</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```
2. 使用<code>@EnableExtension</code>开启扩展功能
```java
@SpringBootApplication
//开启扩展功能
@EnableExtension
public class XyExtensionSamplesApplication {
    public static void main(String[] args) {
        SpringApplication.run(XyExtensionSamplesApplication.class, args);
    }
}
```
3. 在需要使用扩展功能的接口服务上添加注解<code>@Extensible</code>
```java
@Extensible
public interface HelloService {
    void sayHello();
    String helloReturn(String hello);
}
```
4. 在接口实现的对应bean上添加注解<code>@Extension</code>

 实现一：
```java
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
```

实现二：
```java
@Extension(scenario = "us")
@Service
public class EnglishHelloServiceImpl implements HelloService{

    @Override
    public void sayHello() {
        System.out.println("I'm say English: Excuse me?");
    }

    @Override
    public String helloReturn(String hello) {
        return hello + " returned";
    }
}
```

5. 调用方式
```java
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
    }
}
```
## 基本原理
在Spring启动时,通过后置处理器保存了一个bean的mapping, 通过 业务场景+接口 来定位使用对应的bean.
