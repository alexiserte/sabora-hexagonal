package com.sabora.application.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
