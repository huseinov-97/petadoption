package com.bme.authserver;


import com.bme.common.configuration.apidocs.ApiDocsConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
public class AuthserverApplication {
		public static void main(String[] args) {
				SpringApplication.run(AuthserverApplication.class, args);
		}
}
