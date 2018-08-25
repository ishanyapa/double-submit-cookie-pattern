package me.ishanyapa.dscp.controller;

import me.ishanyapa.dscp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api")
public class ContentController {

    @Autowired
    TokenService tokenService;

    @PostMapping(value="/content")
    public String changeContent(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("_csrf") String _csrf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {

            if (cookie.getName().equals("_csrf") && cookie.getValue().equals(_csrf)) {
                return "redirect:/home.html";
            }
        }

        return "redirect:/error.html";
    }
}
