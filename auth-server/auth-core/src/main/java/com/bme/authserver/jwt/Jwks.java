package com.bme.authserver.jwt;


import com.nimbusds.jose.jwk.RSAKey;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

/**
 * Code copied from Spring Authorization server example:
 * https://github.com/spring-projects-experimental/spring-authorization-server/blob/master/samples/boot/oauth2-integration/authorizationserver/src/main/java/sample/jose/Jwks.java
 */
public final class Jwks {
		
		public static RSAKey generateRsa() {
				KeyPair keyPair = KeyGeneratorUtils.generateRsaKey();
				RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
				RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
				return new RSAKey.Builder(publicKey)
						.privateKey(privateKey)
						.keyID(UUID.randomUUID().toString())
						.build();
		}
}
