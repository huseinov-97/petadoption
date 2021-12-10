package com.bme.common.configuration.apidocs;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;



/**
 * In applications, where we want to call another service services we should import that service's api module.
 * This configuration will map feign find the declared feign clients in those packages too.
 */

@Configuration
@EnableFeignClients(basePackages= "com.bme")
public class FeignConfiguration {
		
		@Value("${petadoption.security.auth-server-url}")
		private String authServerUrl;
		
		@Value("${petadoption.security.client-id}")
		private String clientId;
		
		@Value("${petadoption.security.client-secret}")
		private String clientSecret;

	@Bean
	public OAuth2FeignRequestInterceptor oauth2schemeRequestInterceptor() {
		return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), oauth2schemeResourceDetails());
	}

	@Bean
	public ClientCredentialsResourceDetails oauth2schemeResourceDetails() {
		ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
		details.setClientId(clientId);
		details.setClientSecret(clientSecret);
		details.setAccessTokenUri(authServerUrl + "/token");
		return details;
	}
}
