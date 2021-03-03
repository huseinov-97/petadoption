package com.bme.authserver;


import com.bme.authserver.jwt.Jwks;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import io.swagger.models.HttpMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.web.OAuth2TokenEndpointFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.List;


@EnableWebSecurity
public class AuthorizationServerConfig {
		
		/**
		 * TODO: workao
		 * @param http
		 * @return
		 * @throws Exception
		 */
		
		@Bean
		public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
				OAuth2AuthorizationServerConfigurer<HttpSecurity> authorizationServerConfigurer = new OAuth2AuthorizationServerConfigurer();
				
				List<RequestMatcher> requestMatchers = new ArrayList<>();
				requestMatchers.add(authorizationServerConfigurer.getEndpointsMatcher());
				requestMatchers.add(new AntPathRequestMatcher(OAuth2TokenEndpointFilter.DEFAULT_TOKEN_ENDPOINT_URI, HttpMethod.OPTIONS.name()));
				
				http.cors().and()
						.requestMatcher(new OrRequestMatcher(requestMatchers))
						.authorizeRequests((authorizeRequests) -> {
								((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)authorizeRequests.anyRequest()).authenticated();
						}).csrf((csrf) -> {
						csrf.ignoringRequestMatchers(new RequestMatcher[]{tokenEndpointMatcher()});
				}).apply(authorizationServerConfigurer);
				
				return http.build();
		}
		
		private static RequestMatcher tokenEndpointMatcher() {
				return new AntPathRequestMatcher(
						OAuth2TokenEndpointFilter.DEFAULT_TOKEN_ENDPOINT_URI,
						HttpMethod.POST.name());
		}
		
		@Bean
		public CorsConfigurationSource corsConfigurationSource() {
				UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
				source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
				return source;
		}
		
		/**
		 * Here we are now burning what kind of clients (application components) we have in the system.
		 * @return
		 */
		@Bean
		public RegisteredClientRepository registeredClientRepository() {
				// A frontend
				RegisteredClient frontendClient = RegisteredClient.withId("1138c5af-fd56-4a58-8c8f-769c2e327433")
						.clientId("petadoption-frontend")
						.clientSecret("ca8831eb-e504-46f1-a514-8be84ba892ed") // In principle, this should not be specified for a public client
						.clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
						.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
						.redirectUri("http://localhost:4200/*")
						.redirectUri("http://localhost:8080/swagger-ui/oauth2-redirect.html")
						.build();
				
				// API-Gateway
				RegisteredClient apiGateway = RegisteredClient.withId("c681c3d5-fa87-4cd7-b8fc-650862c0cc6e")
						.clientId("api-gateway")
						.clientSecret("546c5e7b-bd66-4df3-a601-8a31a4bee482")
						.clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
						.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
						.build();
				
				// adoptation service
				RegisteredClient adoptationService = RegisteredClient.withId("1b233dee-7150-4334-b50e-99943ce00479")
						.clientId("adoptation-service")
						.clientSecret("eb2d6d80-417c-44d0-8e4a-3b105e154258")
						.clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
						.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
						.build();
				
				// pet service
				RegisteredClient petService = RegisteredClient.withId("d99642ac-78ca-47e1-ae13-85d8836ed5ca")
						.clientId("pet-service")
						.clientSecret("16092ceb-a272-4e02-a286-abc28a3b1b97")
						.clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
						.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
						.build();
				
				// Shelter service
				RegisteredClient shelterService = RegisteredClient.withId("8a1d5246-b465-4672-a14b-796559ff1d34")
						.clientId("shelter-service")
						.clientSecret("65584896-10bc-4965-9e2f-824765977736")
						.clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
						.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
						.build();
				
				
				
				return new InMemoryRegisteredClientRepository(
						frontendClient,
						apiGateway,
						adoptationService,
						petService,
						shelterService
				);
		}
		
		@Bean
		public JWKSource<SecurityContext> jwkSource() {
				RSAKey rsaKey = Jwks.generateRsa();
				JWKSet jwkSet = new JWKSet(rsaKey);
				return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
		}
		
		
}
