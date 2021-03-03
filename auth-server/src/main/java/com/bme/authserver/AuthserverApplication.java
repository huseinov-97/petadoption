package com.bme.authserver;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class AuthserverApplication {

		public static void main(String[] args) {
				SpringApplication.run(AuthserverApplication.class, args);
		}
}
