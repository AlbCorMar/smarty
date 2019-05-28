package com.project.smarty.controllers;

import com.project.smarty.model.mail.IEmailSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class emailController {

    @Autowired
    IEmailSrv emailSrv;

    @GetMapping("/Mail/ChangePassword/{idUsuario}")
    public Map listhistorical(@PathVariable("idUsuario") Integer idUsuario) {
        HashMap<String, Object> res=new HashMap<>();
        try {
            emailSrv.configAndSendMail(idUsuario);
        }catch(Exception e) {
            res.put("error", "Error: " + e.getMessage());
        }
        return res;
    }
}
