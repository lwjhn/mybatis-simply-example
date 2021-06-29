package com.rongji.egov.example.service.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("${spring.application.name}")
public class TestController {

    @GetMapping("/test/token")
    public String getToken(@RequestHeader("x-auth-token") String token){
         return token;
    }
}
