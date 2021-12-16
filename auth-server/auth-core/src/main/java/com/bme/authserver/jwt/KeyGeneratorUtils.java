package com.bme.authserver.jwt;


import java.security.KeyPair;
import java.security.KeyPairGenerator;

/**
 * Code copied from Spring Authorization server example:
 * https://github.com/spring-projects-experimental/spring-authorization-server/blob/master/samples/boot/oauth2-integration/authorizationserver/src/main/java/sample/jose/KeyGeneratorUtils.java
 */
final class KeyGeneratorUtils {
		
		private KeyGeneratorUtils() {
		}
		
		static KeyPair generateRsaKey() {
				KeyPair keyPair;
				try {
						KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
						keyPairGenerator.initialize(2048);
						keyPair = keyPairGenerator.generateKeyPair();
				} catch (Exception ex) {
						throw new IllegalStateException(ex);
				}
				return keyPair;
		}
}
