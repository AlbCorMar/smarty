package com.project.smarty.model.services;

import com.project.smarty.beans.DTO.UsuarioDto;
import com.project.smarty.beans.RoleBean;
import com.project.smarty.beans.UsuarioBean;
import com.project.smarty.model.repository.UsuarioRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import javax.validation.constraints.Null;
import java.util.*;

@Service
public class UsuarioSrv implements IUsuarioSrv {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioBean saveUser(UsuarioDto userDto, List<String > roles) throws Exception {
        if (userDto.getPassword().compareTo(userDto.getRepitPassword())!=0){
            throw new Exception("Las contraseñas no coinciden");
        }
        UsuarioBean user = modelMapper.map(userDto, UsuarioBean.class);;
        if (usuarioRepository.findByUserName(user.getUserName()).size() > 0){
            throw new Exception("Este usuario ya está registrado");
        } else {
            List<RoleBean> rolesBean = new ArrayList<>();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            for(String role:roles){
                RoleBean rol = new RoleBean();
                rol.setIdRole(null);
                rol.setRole(role);
                rol.setUsuario(user);
                rolesBean.add(rol);
            }

            user.setRoles(rolesBean);
            if (user.getIdUsuario()==null){
                usuarioRepository.save(user);
            }else{
                usuarioRepository.saveAndFlush(user);
            }
        }
        return user;
    }

    public UsuarioDto getUser(String username) throws Exception {
        UsuarioBean userBean =  usuarioRepository.getByUserName(username);
        UsuarioDto userDto = modelMapper.map(userBean, UsuarioDto.class);
        return userDto;
    }

    public void deleteUser(Integer id) throws Exception {
        usuarioRepository.deleteById(id);
    }

}
