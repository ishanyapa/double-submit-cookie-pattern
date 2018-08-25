package me.ishanyapa.dscp.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {

    public String generateNewToken() {
        return UUID.randomUUID().toString();
    }

    public boolean compareTokens(String headerToken, String formToken) {
        return headerToken.equals(formToken);
    }
}
