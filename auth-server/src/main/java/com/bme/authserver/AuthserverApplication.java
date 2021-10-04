package com.bme.authserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
//@Import({ApiDocsConfiguration.class, ResourceServerWebSecurityConfig.class})
@EnableSwagger2
public class AuthserverApplication {
		public static void main(String[] args) {
				SpringApplication.run(AuthserverApplication.class, args);
		}
}
