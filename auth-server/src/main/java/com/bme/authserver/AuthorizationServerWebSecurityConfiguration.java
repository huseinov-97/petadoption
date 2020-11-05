package com.bme.authserver;


import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.web.OAuth2TokenEndpointFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.List;


public class AuthorizationServerWebSecurityConfiguration extends WebSecurityConfigurerAdapter {
		
		@Override
		protected void configure(HttpSecurity http)throws Exception{
				OAuth2AuthorizationServerConfigurer<HttpSecurity> auth2AuthorizationServerConfigurer =
						new OAuth2AuthorizationServerConfigurer<>();
				
				List<RequestMatcher> requestMatchers = new ArrayList<>(auth2AuthorizationServerConfigurer.getEndpointMatchers());
				requestMatchers.add(new AntPathRequestMatcher(OAuth2TokenEndpointFilter.DEFAULT_TOKEN_ENDPOINT_URI, HttpMethod.OPTIONS.name()));
				http
						.cors()
						.and()
						.requestMatcher(new OrRequestMatcher(requestMatchers))
						.authorizeRequests(authorizeRequests->
								authorizeRequests.anyRequest()
										.authenticated())
						.formLogin(Customizer.withDefaults())
						.csrf(csrf -> csrf.ignoringRequestMatchers(tokenEndpointMatcher()))
						.apply(auth2AuthorizationServerConfigurer);
		}
		private static RequestMatcher tokenEndpointMatcher() {
				return new AntPathRequestMatcher(
						OAuth2TokenEndpointFilter.DEFAULT_TOKEN_ENDPOINT_URI,
						HttpMethod.POST.name());
		}
}
