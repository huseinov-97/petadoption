package com.bme.common.configuration.apidocs;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class ResourceServerWebSecurityConfig extends WebSecurityConfigurerAdapter{
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
						 http
						.authorizeRequests()
						.antMatchers("/swagger-resources/**",
								"/swagger-ui/",
								"/webjars/springfox-swagger-ui/**",
								"/v2/api-docs**",
								"/swagger**", "/pet/pets/**", "shelter/shelters/**")
						.permitAll();
//						.anyRequest()
//						.authenticated()
//						.and()
//						.oauth2ResourceServer()
//						.jwt();
		}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
		
}
