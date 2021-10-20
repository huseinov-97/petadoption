package com.bme.petservice;


import com.bme.common.configuration.apidocs.ApiDocsConfiguration;
import com.bme.common.configuration.apidocs.ResourceServerWebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@Import({ApiDocsConfiguration.class, ResourceServerWebSecurityConfig.class})
@EnableSwagger2
public class PetserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetserviceApplication.class, args);
    }
}
