package com.bme.apigateway;


import com.bme.common.configuration.apidocs.ApiDocsConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableZuulProxy
@SpringBootApplication
@Import(ApiDocsConfiguration.class)
@Slf4j
@EnableSwagger2
public class ApiGatewayApplication {
		public static void main(String[] args) {
				SpringApplication.run(ApiGatewayApplication.class, args);
		}
}
