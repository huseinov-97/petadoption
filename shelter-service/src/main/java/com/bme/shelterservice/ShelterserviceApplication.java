package com.bme.shelterservice;


import com.bme.common.configuration.apidocs.ApiDocsConfiguration;
import com.bme.common.configuration.apidocs.FeignConfiguration;
import com.bme.common.configuration.apidocs.ResourceServerWebSecurityConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({ApiDocsConfiguration.class, ResourceServerWebSecurityConfig.class, FeignConfiguration.class})
@Slf4j
public class ShelterserviceApplication {

		public static void main(String[] args) {
				SpringApplication.run(ShelterserviceApplication.class, args);
		}

}
