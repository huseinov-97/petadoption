package com.bme.petservice;


import com.bme.common.configuration.ApiDocsConfiguration;
import com.bme.common.configuration.ResourceServerWebSecurityConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;



@SpringBootApplication
@Import({ApiDocsConfiguration.class, ResourceServerWebSecurityConfig.class})
@Slf4j
public class PetserviceApplication {

		public static void main(String[] args) {
				SpringApplication.run(PetserviceApplication.class, args);
		}

}
