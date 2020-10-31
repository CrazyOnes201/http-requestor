package com.crazy.walker.http.requestor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HttpRequestorApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpRequestorApplication.class, args);
    }

}
