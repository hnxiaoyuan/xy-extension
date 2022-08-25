package org.example.extension;

import com.xyspring.extension.annotation.EnableExtension;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableExtension
public class XyExtensionSamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyExtensionSamplesApplication.class, args);
    }

}
