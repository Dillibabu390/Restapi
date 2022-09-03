package com.api.task.entity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private KeyPairGenerator keyPairGenerator;
    private KeyPair keyPair;
    public JwtUtils() throws NoSuchAlgorithmException {

        keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        keyPair = keyPairGenerator.generateKeyPair();
    }

    public String generateJwt(User payload) throws Exception {

        payload.setPassword("************");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> map = objectMapper.convertValue(payload,Map.class);
        JWTCreator.Builder tokenBuilder = JWT.create()
                .withPayload(map)
                .withExpiresAt(Date.from(Instant.now().plusSeconds(300)))
                .withIssuedAt(Date.from((Instant.now())));
        return tokenBuilder.sign(Algorithm.RSA256(((RSAPublicKey) keyPair.getPublic()), ((RSAPrivateKey) keyPair.getPrivate())));
    }
}
