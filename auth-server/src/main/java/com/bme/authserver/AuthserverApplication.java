package com.bme.authserver;


import com.bme.common.configuration.apidocs.ApiDocsConfiguration;
import com.bme.common.configuration.apidocs.ResourceServerWebSecurityConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@Import({ApiDocsConfiguration.class, ResourceServerWebSecurityConfig.class})
@Slf4j
@EnableSwagger2
public class AuthserverApplication {
		public static void main(String[] args) {
				SpringApplication.run(AuthserverApplication.class, args);
		}
}
