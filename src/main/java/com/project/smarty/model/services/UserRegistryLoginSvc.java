package com.project.smarty.model.services;

import com.project.smarty.beans.UsuarioBean;
import com.project.smarty.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRegistryLoginSvc implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioBean usuario = usuarioRepository.getByUserName(username);
        User res = new User(usuario.getUserName(), usuario.getPassword(), usuario.getRoles());
        return res;
    }
}
