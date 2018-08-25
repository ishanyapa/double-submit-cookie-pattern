package me.ishanyapa.dscp.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {

    private final String _CSRF = "_csrf";

    public String generateNewToken() {
        return UUID.randomUUID().toString();
    }

    public boolean compareTokens(String name, String headerToken, String formToken) {
        return name.equals(_CSRF) && headerToken.equals(formToken);
    }
}
