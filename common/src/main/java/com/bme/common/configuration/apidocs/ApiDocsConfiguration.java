package com.bme.common.configuration.apidocs;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;

import java.util.Collections;


@Configuration
public class ApiDocsConfiguration {

    @Value("${petadoption.security.auth-server-url}")
    private String authServerUrl;

    private static final String CLIENT_ID = "petadoption-frontend";
    private static final String CLIENT_SECRET = "ca8831eb-e504-46f1-a514-8be84ba892ed";

    @Value("${petadoption.security.client-id}")
    private String clientId;

    @Value("${petadoption.security.client-secret}")
    private String clientSecret;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bme"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Collections.singletonList(securityScheme()))
                .securityContexts(Collections.singletonList(securityContext()));
    }

    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .scopeSeparator(" ")
                .useBasicAuthenticationWithAccessCodeGrant(true)
                .build();
    }

    /**
     * The security scheme tells you how security works.
     *
     * @return
     */
    private SecurityScheme securityScheme() {
        GrantType grantType = new AuthorizationCodeGrantBuilder()
                .tokenEndpoint(b -> b.url(authServerUrl + "/token").tokenName("oauthToken"))
                .tokenRequestEndpoint(b -> b.url(authServerUrl + "/authorize").clientIdName(clientId).clientSecretName(clientSecret)).build();
        return new OAuthBuilder().name("spring-oauth")
                .grantTypes(Collections.singletonList(grantType))
                .build();
    }

    /**
     * The security context tells you when to use security. Now use if there is no / public at the endpoint
     *
     * @return
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(
                        new SecurityReference("spring-oauth",
                                new AuthorizationScope[]{})))
                .operationSelector(s -> !s.requestMappingPattern().matches(".*/public.*"))
                .build();
    }
}
