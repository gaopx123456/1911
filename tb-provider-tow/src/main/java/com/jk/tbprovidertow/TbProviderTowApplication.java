package com.jk.tbprovidertow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TbProviderTowApplication {

    public static void main(String[] args) {
        SpringApplication.run(TbProviderTowApplication.class, args);
    }

}
