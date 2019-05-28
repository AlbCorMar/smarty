package com.project.smarty.model.repository;

import com.project.smarty.beans.UsuarioBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioBean, Integer> {

    List<UsuarioBean> findByUserName(String userName);
    UsuarioBean getByUserName(String userName);
}
