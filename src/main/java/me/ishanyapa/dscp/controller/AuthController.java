package me.ishanyapa.dscp.controller;

import me.ishanyapa.dscp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/api")
public class AuthController extends BaseController {

    @Autowired
    TokenService tokenService;

    @PostMapping(value = "/login")
    public void login(@RequestParam("email") String email, @RequestParam("password") String password,
                      HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (String.valueOf(email).equals("ishanyapa@gmail.com") && String.valueOf(password).equals("123")) {

            Cookie cookie = new Cookie("_csrf", tokenService.generateNewToken());
            cookie.setPath("/");
            response.addCookie(cookie);
            HttpSession httpSession = request.getSession(true);
            response.encodeURL("/home.html");
            return;
        }

        response.sendError(401);
    }

    @PostMapping(value = "/logout", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.getSession(false).invalidate();
        response.sendRedirect("/");
    }
}
