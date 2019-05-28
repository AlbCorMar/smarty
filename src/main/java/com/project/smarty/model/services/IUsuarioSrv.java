package com.project.smarty.model.services;

import com.project.smarty.beans.DTO.UsuarioDto;
import com.project.smarty.beans.UsuarioBean;

import java.util.List;

public interface IUsuarioSrv {

    UsuarioBean saveUser(UsuarioDto user, List<String> roles) throws Exception;
    UsuarioDto getUser(String username) throws Exception;
    void deleteUser(Integer id) throws Exception;
}
