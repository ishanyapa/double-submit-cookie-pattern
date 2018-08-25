package me.ishanyapa.dscp.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

public class BaseController {

    @ExceptionHandler(IOException.class)
    public String handleIOException(IOException e) {
        return "redirect:/error.html";
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException e) {
        return "redirect:/error.html";
    }

}
