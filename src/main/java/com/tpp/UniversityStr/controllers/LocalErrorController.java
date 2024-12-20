package com.tpp.UniversityStr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocalErrorController {

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";  
    }
}
