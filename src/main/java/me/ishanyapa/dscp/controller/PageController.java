package me.ishanyapa.dscp.controller;

import me.ishanyapa.dscp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PageController extends BaseController {

    @Autowired
    TokenService tokenService;

    @GetMapping(value="/")
    public String getRoot(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getSession(false)== null) {
            return "redirect:/index.html";
        }
        return "redirect:/home.html";
    }

    @GetMapping(value="/index.html")
    public String getIndex(HttpServletRequest request, HttpServletResponse response) {
        if(request.getSession(false)== null) {
            return "/index.html";
        }
        return "redirect:/home.html";
    }

    @GetMapping(value="/home.html")
    public String getHome(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getSession(false) == null) {
            return "redirect:/index.html";
        }
        return "/home.html";
    }

}
