package com.thienit.quanlydoanvien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
	
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	
	@GetMapping("/dashboard")
    public String dashboard() {
        return "layout/main-content";
    }
}
