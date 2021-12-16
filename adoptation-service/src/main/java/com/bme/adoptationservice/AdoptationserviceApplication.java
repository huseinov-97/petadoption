package com.bme.adoptationservice;


import com.bme.common.configuration.apidocs.ApiDocsConfiguration;
import com.bme.common.configuration.apidocs.ResourceServerWebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({ApiDocsConfiguration.class, ResourceServerWebSecurityConfig.class})
public class AdoptationserviceApplication {

		public static void main(String[] args) {
				SpringApplication.run(AdoptationserviceApplication.class, args);
		}

}
