package com.sabora.application.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User {

    private String dni;
    private String name;
    private String apellidos;
    private String email;
    private String password;
    private String telefono;
    /*  Funcionará con teléfonos españoles, pero si se trata de algún número internacional que empiece por cero puede causar problemas*/
    private String username;

}
