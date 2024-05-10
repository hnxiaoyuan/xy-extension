package org.example.extension.controller;

import com.xyspring.extension.ExtensionExecutor;
import org.example.extension.controller.request.ParamDto;
import org.example.extension.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.WritableResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.annotation.Resource;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * @author DM
 */
@RestController
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Resource
    ExtensionExecutor extensionExecutor;

    @RequestMapping("/param")
    public Object paramBind(ParamDto paramDto){
        System.out.println(paramDto.getUserName());
        return "success:" + paramDto.getUserName() +"," + paramDto.getPassWd();
    }

    @RequestMapping("/hello-world")
    public Object hello(@RequestParam String name, @RequestHeader(required = false) String loginId){
        log.info("获取到用户信息:{}", loginId);
        //业务场景
        final String scenario = name.length() > 1 ? "china" : "us";
        //调用HelloService的sayHello方法
        extensionExecutor.executeVoid(HelloService.class, scenario, HelloService::sayHello);
        //调用HelloService的helloReturn方法
        String param1 = "hello";
        return extensionExecutor.execute(HelloService.class, scenario, func -> func.helloReturn(param1)
        );
    }

    @RequestMapping("/export-file")
    public ResponseEntity<StreamingResponseBody> exportFile(){
        File file = new File("C:\\Users\\DM\\Desktop\\新员工注意事项.txt");
        StreamingResponseBody responseBody = outputStream -> StreamUtils.copy(Files.newInputStream(file.toPath()), outputStream);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=test.txt")
                .contentType(MediaType.APPLICATION_OCTET_STREAM).body(responseBody);
    }
}
