package com.project.smarty.beans;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "usuarios")
public class UsuarioBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idUsuario")
    private Integer idUsuario;

    @NotEmpty(message = "{error.userName.empty}")
    private String userName;

    @NotEmpty(message = "{error.password.empty}")
    private String password;

    @NotEmpty(message = "{error.firstName.empty}")
    private String firstName;

    @NotEmpty(message = "{error.lastName.empty}")
    private String lastName;

    @Email(message = "{error.email.format}")
    private String email;

    private String address;

    private String city;

    private String country;

    private String postalCode;

    private String aboutMe;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch=FetchType.EAGER)
    private List<RoleBean> roles;
}
