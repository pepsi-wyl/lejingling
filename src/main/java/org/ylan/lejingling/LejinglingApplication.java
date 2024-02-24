package org.ylan.lejingling;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ylan
 */

@SpringBootApplication
@MapperScan("org.ylan.lejingling.mapper")
public class LejinglingApplication {
    public static void main(String[] args) {
        SpringApplication.run(LejinglingApplication.class, args);
    }
}