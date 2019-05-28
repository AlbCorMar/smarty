package com.project.smarty.beans;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Roles")
public class RoleBean implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idRole")
    private Integer idRole;

    private String role;

    @ManyToOne
    @JoinColumn(name="idusuario")
    private UsuarioBean usuario;

    @Override
    public String getAuthority(){
        return role;
    }


}
