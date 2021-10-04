package com.bme.apigateway;


import com.bme.common.configuration.apidocs.ApiDocsConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;


@EnableZuulProxy
@SpringBootApplication
@Import(ApiDocsConfiguration.class)
public class ApiGatewayApplication {
		public static void main(String[] args) {
				SpringApplication.run(ApiGatewayApplication.class, args);
		}
}
