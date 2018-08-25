package me.ishanyapa.dscp.controller;

import me.ishanyapa.dscp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class SecurityController extends BaseController {

    @Autowired
    TokenService tokenService;

    @GetMapping(value= "/csrf", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getCsrfToken(HttpServletRequest request) {

        String token = "";

        if (request.getSession(false).getId() != null) {
            token = tokenService.generateNewToken();
        }

        return token;
    }
}
