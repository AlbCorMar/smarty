package com.project.smarty.controllers;

import com.project.smarty.beans.DTO.UsuarioDto;
import com.project.smarty.beans.UsuarioBean;
import com.project.smarty.model.services.UsuarioSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/User")
public class UsuarioController {

    @Autowired
    UsuarioSrv usuarioSrv;

    @GetMapping("/Get/{username}")
    public Map getUser(@PathVariable("username") String username){
        HashMap<String, Object> res = new HashMap<>();
        try {
            res.put("data", usuarioSrv.getUser(username));

        }catch (Exception e) {
            res.put("error", e.getMessage());
        }
        return res;
    }

    @GetMapping("/Delete/{id}")
    public Map DeleteUser(@PathVariable("id") Integer id){
        HashMap<String, Object> res = new HashMap<>();
        try {
            usuarioSrv.deleteUser(id);

        }catch (Exception e) {
            res.put("error", e.getMessage());
        }
        return res;
    }

    @PostMapping("/Save")
    public Map SaveUser(@Valid UsuarioDto usuario, String[] getroles, BindingResult bindingResult){
        HashMap<String, Object> res = new HashMap<>();
        if (bindingResult.hasErrors()){
            String s="1";
        }
        try {
            usuarioSrv.saveUser(usuario, Arrays.asList(getroles));
        } catch (Exception e) {
            res.put("error", e.getMessage()!=null ? e.getMessage():"error aceso");
        }
        return res;
    }
}
