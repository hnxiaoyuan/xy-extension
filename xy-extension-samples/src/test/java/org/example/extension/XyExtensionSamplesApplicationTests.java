package org.example.extension;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

@SpringBootTest
class XyExtensionSamplesApplicationTests {

    @Test
    void contextLoads() {
        AnnotationBeanNameGenerator.class.toString();
    }

}
