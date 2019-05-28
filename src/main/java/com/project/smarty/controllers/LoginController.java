package com.project.smarty.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @PostMapping("/Auth/Login")
    public Map login(String logUsername, String logPassword){
        HashMap<String, Object> res = new HashMap<>();
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(logUsername, logPassword);
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            if (!auth.isAuthenticated()) {
                res.put("error", "Usuario/password incorrectos");
            }
        }catch(Exception e) {
            res.put("error", "Error : Usuario/password incorrectos");
        }
        return res;
    }

    @GetMapping("/Auth/Logout")
    public Map logout() {
        HashMap<String, Object> res = new HashMap<>();
        try {
            SecurityContextHolder.clearContext();
            res.put("redirect", "/login");
        } catch (Exception e) {
            res.put("error", "Error : " + e.getMessage());
        }
        return res;
    }

}
