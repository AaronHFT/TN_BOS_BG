package org.java;

import org.activiti.spring.boot.SecurityAutoConfiguration;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TnBosBackgroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(TnBosBackgroundApplication.class, args);
    }
}
