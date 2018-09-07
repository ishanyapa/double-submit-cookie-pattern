package me.ishanyapa.dscp.controller;

import me.ishanyapa.dscp.constant.Constants;
import me.ishanyapa.dscp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void login(@RequestBody MultiValueMap<String, String> form,
                      HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (String.valueOf(form.getFirst(Constants.EMAIL)).equals(Constants.EMAIL_VALUE) && String.valueOf(form.getFirst(Constants.PASSWORD)).equals(Constants.PASSWORD_VALUE)) {
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
