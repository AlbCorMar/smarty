package com.project.smarty.beans.DTO;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class UsuarioDto {

    private String idUsuario;

    @NotEmpty(message = "{error.userName.empty}")
    private String userName;

    @NotEmpty(message = "{error.password.empty}\"")
    @Size(min=6, max=8, message = "{error.password.size}")
    //@Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[$@$!%*?&])([A-Za-z\\d$@$!%*?&]|[^ ]){8,15}$/", message = "{error.password.p}")
    private String password;

    private String repitPassword;

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
    private List<RolesDto> roles;

}
